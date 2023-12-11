package com.tampusdev.tampus.controller.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FileUploadResponse {

    private int id;
    private String fileName;
    private String fileUri;
    private String fileDownloadUri;
    private long fileSize;
 
}