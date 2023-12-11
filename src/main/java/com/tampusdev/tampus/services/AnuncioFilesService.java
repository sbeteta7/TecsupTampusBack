package com.tampusdev.tampus.services;

import com.tampusdev.tampus.controller.models.AnuncioFilesRequest;
import com.tampusdev.tampus.controller.models.AnuncioFilesResponse;
import com.tampusdev.tampus.controller.models.EtiquetaResponse;
import com.tampusdev.tampus.controller.models.FileUploadResponse;

import java.util.List;

public interface AnuncioFilesService {

    List<AnuncioFilesResponse> associateAnuncioFiles(AnuncioFilesRequest request);

    List<FileUploadResponse> getFilesByAnuncio(Integer id_anuncio);

}
