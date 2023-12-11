package com.tampusdev.tampus.services;

import com.tampusdev.tampus.controller.models.FavoritosResponse;
import com.tampusdev.tampus.persistence.DTO.AnuncioDto;
import com.tampusdev.tampus.persistence.entities.Anuncio;
import com.tampusdev.tampus.persistence.entities.FavoritosEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface FavoritosService {
    ResponseEntity<String> associateFavoritoAnuncioUsuario(FavoritosResponse request);

    List<AnuncioDto> obtenerFavoritosUsuario(Integer userId);
}