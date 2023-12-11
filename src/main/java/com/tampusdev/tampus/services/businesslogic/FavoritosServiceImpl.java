package com.tampusdev.tampus.services.businesslogic;
import com.tampusdev.tampus.controller.models.FavoritosResponse;
import com.tampusdev.tampus.persistence.DTO.AnuncioDto;
import com.tampusdev.tampus.persistence.entities.Anuncio;
import com.tampusdev.tampus.persistence.entities.FavoritosEntity;
import com.tampusdev.tampus.persistence.entities.Usuario;
import com.tampusdev.tampus.persistence.repository.AnuncioRepository;
import com.tampusdev.tampus.persistence.repository.FavoritosRepository;
import com.tampusdev.tampus.persistence.repository.UserRepository;
import com.tampusdev.tampus.services.FavoritosService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FavoritosServiceImpl implements FavoritosService {

    private final FavoritosRepository favoritosRepository;
    private final UserRepository usuarioRepository;
    private final AnuncioRepository anuncioRepository;

    @Override
    public ResponseEntity<String> associateFavoritoAnuncioUsuario(FavoritosResponse request) {
        Usuario usuario = usuarioRepository.findById(request.getId_usuario())
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Anuncio anuncio = anuncioRepository.findById(request.getId_anuncio())
                .orElseThrow(() -> new RuntimeException("Anuncio no encontrado"));

        FavoritosEntity favorito = FavoritosEntity.builder()
                .idUsuario(usuario)
                .id_anuncio(anuncio)
                .estado_favorito(true)
                .fecha_creacion(LocalDate.now())
                .build();
        favoritosRepository.save(favorito);

        return new ResponseEntity<>("El anuncio se añadió correctamente a favoritos.", HttpStatus.OK);
    }

    @Override
    public List<AnuncioDto> obtenerFavoritosUsuario(Integer userId) {
        Usuario usuario = usuarioRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        List<FavoritosEntity> favoritos = favoritosRepository.findByIdUsuario(usuario);
        return favoritos.stream()
                .map(this::convertirAAnuncioDto)
                .collect(Collectors.toList());
    }

    private AnuncioDto convertirAAnuncioDto(FavoritosEntity favorito) {
        Anuncio anuncio = favorito.getId_anuncio();
        Usuario usuario = favorito.getIdUsuario();

        return new AnuncioDto(
                anuncio.getId_anuncio(),
                Math.toIntExact(usuario.getId()),
                usuario.getFirstName() + " " + usuario.getLastName(),
                anuncio.getProposito(),
                anuncio.getTitulo(),
                anuncio.getDescripcion(),
                anuncio.getUbicacion(),
                anuncio.getPrecio(),
                anuncio.getTipo_espacio(),
                anuncio.getNum_hab(),
                anuncio.getNum_cama(),
                anuncio.getDimensiones(),
                anuncio.getEstado_anuncio()
        );
    }



}