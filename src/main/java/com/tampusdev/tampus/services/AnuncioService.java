package com.tampusdev.tampus.services;

import com.tampusdev.tampus.controller.models.AnuncioRequest;
import com.tampusdev.tampus.controller.models.AnuncioResponse;
import com.tampusdev.tampus.persistence.entities.Anuncio;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface AnuncioService {

    AnuncioResponse createAnuncio(AnuncioRequest request);

    List<AnuncioResponse> getAllAnuncios();

    Optional<String> getUsuarioByAnuncio(Integer idAnuncio);

    List<AnuncioResponse> getAnunciosByUsuario(Integer idUsuario);

    List<AnuncioResponse> getAnunciosConFiltros( BigDecimal precioMin,BigDecimal precioMax,
                                               String tipoEspacio, int numHab,
                                               int numCama, Integer dimensiones);


}
