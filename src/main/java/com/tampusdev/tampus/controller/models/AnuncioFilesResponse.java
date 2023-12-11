package com.tampusdev.tampus.controller.models;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AnuncioFilesResponse {
    private int id;
    private Integer id_anuncio;
    private Integer id_file;

}
