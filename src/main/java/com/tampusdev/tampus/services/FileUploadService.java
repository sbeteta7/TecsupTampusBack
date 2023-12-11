package com.tampusdev.tampus.services;

import com.tampusdev.tampus.controller.models.FileUploadResponse;
import com.tampusdev.tampus.persistence.entities.FileDetails;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface FileUploadService {

     FileUploadResponse uploadFile(MultipartFile file) throws IOException;
     Resource fetchFileAsResource(int id) throws FileNotFoundException;
     List<FileDetails> getAllFiles();

}
