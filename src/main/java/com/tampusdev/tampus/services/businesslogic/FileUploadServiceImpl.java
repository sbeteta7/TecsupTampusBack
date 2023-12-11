package com.tampusdev.tampus.services.businesslogic;

import com.tampusdev.tampus.controller.models.FileUploadResponse;
import com.tampusdev.tampus.exception.FileNotSupportedException;
import com.tampusdev.tampus.persistence.entities.FileDetails;
import com.tampusdev.tampus.persistence.entities.Usuario;
import com.tampusdev.tampus.persistence.repository.FileDetailsRepository;
import com.tampusdev.tampus.services.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class FileUploadServiceImpl implements FileUploadService {
    /*
    Servicio para subir archivos al servidor
    //Se encarga de guardar los archivos en la carpeta static/image
     */
    public FileUploadServiceImpl() throws IOException {}

    @Autowired
    private FileDetailsRepository fileDetailsRepository;

    private final Path UPLOAD_PATH =
            Paths.get(new ClassPathResource("").getFile().getAbsolutePath()
                    + File.separator + "static"
                    + File.separator + "image");

    @Override
    public FileUploadResponse uploadFile(MultipartFile file) throws IOException {

        // create directory if not exists

        if (!Files.exists(UPLOAD_PATH)) {
            Files.createDirectories(UPLOAD_PATH);
        }

        // file format validation
        if (!file.getContentType().equals("image/jpeg") && !file.getContentType().equals("image/png")) {
            throw new FileNotSupportedException("only .jpeg and .png images are " + "supported");
        }

        String timeStampedFileName = new SimpleDateFormat("ssmmHHddMMyyyy")
                .format(new Date()) + "_" + file.getOriginalFilename();

        Path filePath = UPLOAD_PATH.resolve(timeStampedFileName);
        Files.copy(file.getInputStream(), filePath);

        String fileUri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("/image/").path(timeStampedFileName).toUriString();

        String fileDownloadUri =
                ServletUriComponentsBuilder.fromCurrentContextPath()
                        .path("/file/download/").path(timeStampedFileName).toUriString();

        FileDetails fileDetails = new FileDetails(file.getOriginalFilename(),
                fileUri,
                fileDownloadUri, file.getSize());

        this.fileDetailsRepository.save(fileDetails);
        System.out.println(UPLOAD_PATH);
        return new FileUploadResponse(fileDetails.getId(),
                file.getOriginalFilename(), fileUri, fileDownloadUri,
                file.getSize()
        );


    }

    @Override
    public Resource fetchFileAsResource(int id) throws FileNotFoundException {
        FileDetails fileDetails = this.fileDetailsRepository.findById(id)
                .orElseThrow(() -> new FileNotFoundException("File not found with id " + id));
        String variable =fileDetails.getFileDownloadUri();
        int lastSlashIndex = variable.lastIndexOf('/');
        // Extraer el nombre de archivo a partir de la posición de la última barra inclinada
        String fileName = variable.substring(lastSlashIndex + 1);

        try {
            Path filePath = UPLOAD_PATH.resolve(fileName).normalize();
            Resource resource = new UrlResource(filePath.toUri());

            if (resource.exists()) {
                return resource;
            } else {
                throw new FileNotFoundException("File not found (resource doesn't exist) " + fileDetails.getFileName());
            }
        } catch (MalformedURLException ex) {
            throw new FileNotFoundException("Malformed URL for file with id " + id);
        }
    }

    @Override
    public List<FileDetails> getAllFiles() {
        return this.fileDetailsRepository.findAll();
    }
}