package com.tampusdev.tampus.services;


import com.tampusdev.tampus.controller.models.AnuncioEtiquetaRequest;
import com.tampusdev.tampus.controller.models.AnuncioEtiquetaResponse;

import java.util.List;

public interface AnuncioEtiquetaService {

    List<AnuncioEtiquetaResponse> associateAnuncioEtiquetas(AnuncioEtiquetaRequest request);

}

