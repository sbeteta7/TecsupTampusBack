package com.tampusdev.tampus.services.businesslogic;

import com.tampusdev.tampus.controller.models.AnuncioRequest;
import com.tampusdev.tampus.controller.models.AnuncioResponse;
import com.tampusdev.tampus.persistence.entities.Anuncio;
import com.tampusdev.tampus.persistence.repository.AnuncioRepository;
import com.tampusdev.tampus.services.AnuncioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnuncioServicelmpl implements AnuncioService {

    private final AnuncioRepository anuncioRepository;

    @Override
    public AnuncioResponse createAnuncio(AnuncioRequest request) {
       var anuncio= Anuncio.builder()
               .titulo(request.getTitulo())
               .descripcion(request.getDescripcion())
               .precio_min(request.getPrecio_min())
               .precio_max(request.getPrecio_max())
               .tipo_espacio(request.getTipo_espacio())
               .num_hab(request.getNum_hab())
               .num_cama(request.getNum_cam())
               .dimensiones(request.getDimensiones())
               .build();
       anuncioRepository.save(anuncio);
        return AnuncioResponse.builder().build();

    }

    @Override
    public List<AnuncioResponse> getAllAnuncios() {
        List<Anuncio> anuncios = anuncioRepository.findAll();
        List<AnuncioResponse> anuncioResponses = new ArrayList<>();
        for (Anuncio anuncio : anuncios) {
            AnuncioResponse anuncioResponse = new AnuncioResponse();
            anuncioResponse.setId_anuncio(anuncio.getId_anuncio());
            anuncioResponse.setTitulo(anuncio.getTitulo());
            anuncioResponse.setDescripcion(anuncio.getDescripcion());
            anuncioResponse.setPrecio_min(anuncio.getPrecio_min());
            anuncioResponse.setPrecio_max(anuncio.getPrecio_max());
            anuncioResponse.setTipo_espacio(anuncio.getTipo_espacio());
            anuncioResponse.setNum_hab(anuncio.getNum_hab());
            anuncioResponse.setNum_cam(anuncio.getNum_cama());
            anuncioResponse.setDimensiones(anuncio.getDimensiones());
           //anuncioResponse.setFecha_creacion(anuncio.getFecha_creacion());
            anuncioResponses.add(anuncioResponse);
        }
        return anuncioResponses;
    }
}

