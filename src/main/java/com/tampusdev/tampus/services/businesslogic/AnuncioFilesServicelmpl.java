package com.tampusdev.tampus.services.businesslogic;


import com.tampusdev.tampus.controller.models.AnuncioFilesRequest;
import com.tampusdev.tampus.controller.models.AnuncioFilesResponse;
import com.tampusdev.tampus.controller.models.FileUploadResponse;
import com.tampusdev.tampus.persistence.entities.Anuncio;

import com.tampusdev.tampus.persistence.entities.AnuncioFiles;
import com.tampusdev.tampus.persistence.entities.FileDetails;
import com.tampusdev.tampus.persistence.repository.AnuncioFilesRepository;

import com.tampusdev.tampus.services.AnuncioFilesService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AnuncioFilesServicelmpl implements AnuncioFilesService {

    private final AnuncioFilesRepository anuncioFilesRepository;

    @Override
    public List<AnuncioFilesResponse> associateAnuncioFiles(AnuncioFilesRequest request) {
        List<AnuncioFiles> ListAnuncioFiles = new ArrayList<>();
        for (Integer id_file : request.getId_files()) {
            Anuncio anuncio = new Anuncio();
            anuncio.setId_anuncio(request.getId_anuncio());

            FileDetails fileDetail = new FileDetails();
            fileDetail.setId(id_file);

            var anuncioFile = AnuncioFiles.builder()
                    .id_anuncio(anuncio)
                    .id_file(fileDetail)
                    .build();
            ListAnuncioFiles.add(anuncioFile);
        }
        anuncioFilesRepository.saveAll(ListAnuncioFiles);
        List<AnuncioFilesResponse> anuncioFilesResponses = new ArrayList<>();
        for (AnuncioFiles anuncioFile : ListAnuncioFiles) {
            anuncioFilesResponses.add(AnuncioFilesResponse.builder()
                    .id(anuncioFile.getId())
                    .id_anuncio(anuncioFile.getId_anuncio().getId_anuncio())
                    .id_file(anuncioFile.getId_file().getId())
                    .build());
        }
        return anuncioFilesResponses;
    }

    @Override
    public List<FileUploadResponse> getFilesByAnuncio(Integer id_anuncio) {

        List<AnuncioFiles> anuncioFiles = anuncioFilesRepository.findById_anuncio(id_anuncio);
        List<FileUploadResponse> fileUploadResponses = new ArrayList<>();
        for (AnuncioFiles anuncioFile : anuncioFiles) {
            fileUploadResponses.add(FileUploadResponse.builder()
                    .id(anuncioFile.getId_file().getId())
                    .fileName(anuncioFile.getId_file().getFileName())
                    .fileUri(anuncioFile.getId_file().getFileUri())
                    .fileDownloadUri(anuncioFile.getId_file().getFileDownloadUri())
                    .fileSize(anuncioFile.getId_file().getFileSize())
                    .build());

        }
        return fileUploadResponses;
    }
}
