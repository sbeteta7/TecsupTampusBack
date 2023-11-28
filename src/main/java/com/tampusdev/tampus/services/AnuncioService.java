package com.tampusdev.tampus.services;

import com.tampusdev.tampus.controller.models.AnuncioRequest;
import com.tampusdev.tampus.controller.models.AnuncioResponse;

import java.util.List;

public interface AnuncioService {

    AnuncioResponse createAnuncio(AnuncioRequest request);

    List<AnuncioResponse> getAllAnuncios();


}
