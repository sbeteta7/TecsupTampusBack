package com.tampusdev.tampus.services.businesslogic;

import com.tampusdev.tampus.controller.models.AnuncioRequest;
import com.tampusdev.tampus.controller.models.AnuncioResponse;
import com.tampusdev.tampus.controller.models.UsuarioResponse;
import com.tampusdev.tampus.persistence.entities.Anuncio;
import com.tampusdev.tampus.persistence.entities.Usuario;
import com.tampusdev.tampus.persistence.repository.AnuncioRepository;
import com.tampusdev.tampus.persistence.repository.UserRepository;
import com.tampusdev.tampus.services.AnuncioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AnuncioServicelmpl implements AnuncioService {

    private final AnuncioRepository anuncioRepository;
    private final UserRepository userRepository;

    @Override
    public AnuncioResponse createAnuncio(AnuncioRequest request) {
        Usuario user = new Usuario();
        user.setId(Long.valueOf(request.getId_user()));
        var anuncio= Anuncio.builder()
               .id_user(user)
               .titulo(request.getTitulo())
               .descripcion(request.getDescripcion())
                .ubicacion(request.getUbicacion())
               .precio(request.getPrecio())
               .tipo_espacio(request.getTipo_espacio())
               .num_hab(request.getNum_hab())
               .num_cama(request.getNum_cam())
               .dimensiones(request.getDimensiones())
               .build();
       anuncioRepository.save(anuncio);

        return AnuncioResponse.builder()
                .id_anuncio(anuncio.getId_anuncio())
                .id_user(anuncio.getId_user().getId().intValue())
                .titulo(anuncio.getTitulo())
                .descripcion(anuncio.getDescripcion())
                .ubicacion(anuncio.getUbicacion())
                .precio(anuncio.getPrecio())
                .tipo_espacio(anuncio.getTipo_espacio())
                .num_hab(anuncio.getNum_hab())
                .num_cama(anuncio.getNum_cama())
                .dimensiones(anuncio.getDimensiones())
                .build();

    }

    @Override
    public List<AnuncioResponse> getAllAnuncios() {
        List<Anuncio> anuncios = anuncioRepository.findAll();
        List<AnuncioResponse> anuncioResponses = new ArrayList<>();
        for (Anuncio anuncio : anuncios) {
            AnuncioResponse anuncioResponse = new AnuncioResponse();
            anuncioResponse.setId_anuncio(anuncio.getId_anuncio());
            anuncioResponse.setId_user(anuncio.getId_user().getId().intValue());
            anuncioResponse.setTitulo(anuncio.getTitulo());
            anuncioResponse.setDescripcion(anuncio.getDescripcion());
            anuncioResponse.setUbicacion(anuncio.getUbicacion());
            anuncioResponse.setPrecio(anuncio.getPrecio());

            anuncioResponse.setTipo_espacio(anuncio.getTipo_espacio());
            anuncioResponse.setNum_hab(anuncio.getNum_hab());
            anuncioResponse.setNum_cama(anuncio.getNum_cama());
            anuncioResponse.setDimensiones(anuncio.getDimensiones());
            anuncioResponses.add(anuncioResponse);
        }
        return anuncioResponses;
    }

    @Override
    public Optional<String> getUsuarioByAnuncio(Integer id_anuncio) {
        Optional<Anuncio> anuncioOptional = anuncioRepository.findById(id_anuncio);

        if (anuncioOptional.isPresent()) {
            Anuncio anuncio = anuncioOptional.get();
            Optional<Usuario> usuarioOptional = userRepository.findById(Math.toIntExact(anuncio.getId_user().getId()));

            if (usuarioOptional.isPresent()) {
                Usuario usuario = usuarioOptional.get();
                String nombreApellido = usuario.getFirstName() + " " + usuario.getLastName();
                return Optional.of(nombreApellido);
            }
        }

        return Optional.empty();
    }

    @Override
    public List<AnuncioResponse> getAnunciosByUsuario(Integer idUsuario) {
        Usuario usuario = userRepository.findById(idUsuario).orElse(null);
        List<AnuncioResponse> anuncioResponses = new ArrayList<>();
        if (usuario != null) {
            List<Anuncio> anuncios = anuncioRepository.findAnuncioById_user(usuario);

            for (Anuncio anuncio : anuncios){
                AnuncioResponse anuncioResponse = new AnuncioResponse();
                anuncioResponse.setId_anuncio(anuncio.getId_anuncio());
                anuncioResponse.setId_user(anuncio.getId_user().getId().intValue());
                anuncioResponse.setTitulo(anuncio.getTitulo());
                anuncioResponse.setDescripcion(anuncio.getDescripcion());
                anuncioResponse.setUbicacion(anuncio.getUbicacion());
                anuncioResponse.setPrecio(anuncio.getPrecio());
                anuncioResponse.setTipo_espacio(anuncio.getTipo_espacio());
                anuncioResponse.setNum_hab(anuncio.getNum_hab());
                anuncioResponse.setNum_cama(anuncio.getNum_cama());
                anuncioResponse.setDimensiones(anuncio.getDimensiones());

                anuncioResponses.add(anuncioResponse);
            }
        }
        return anuncioResponses;

        }

    @Override
    public List<AnuncioResponse> getAnunciosConFiltros(BigDecimal precioMin,BigDecimal precioMax,
                                                        String tipoEspacio, int numHab,
                                                       int numCama, Integer dimensiones) {
        List<Anuncio> anuncios = anuncioRepository.findByFiltros(precioMin,precioMax, tipoEspacio, numHab, numCama, dimensiones);
        List<AnuncioResponse> anuncioResponses = new ArrayList<>();
        for (Anuncio anuncio : anuncios) {
            AnuncioResponse anuncioResponse = new AnuncioResponse();
            anuncioResponse.setId_anuncio(anuncio.getId_anuncio());
            anuncioResponse.setId_user(anuncio.getId_user().getId().intValue());
            anuncioResponse.setTitulo(anuncio.getTitulo());
            anuncioResponse.setDescripcion(anuncio.getDescripcion());
            anuncioResponse.setUbicacion(anuncio.getUbicacion());
            anuncioResponse.setPrecio(anuncio.getPrecio());

            anuncioResponse.setTipo_espacio(anuncio.getTipo_espacio());
            anuncioResponse.setNum_hab(anuncio.getNum_hab());
            anuncioResponse.setNum_cama(anuncio.getNum_cama());
            anuncioResponse.setDimensiones(anuncio.getDimensiones());
            anuncioResponses.add(anuncioResponse);
        }

        return anuncioResponses;
    }

}




