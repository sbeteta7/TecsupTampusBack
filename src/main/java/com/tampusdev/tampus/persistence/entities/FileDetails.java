package com.tampusdev.tampus.persistence.entities;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class FileDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String fileName;
    @Column
    private String fileUri;
    @Column
    private String fileDownloadUri;
    @Column
    private long fileSize;



    public FileDetails(String fileName, String fileUri,
                       String fileDownloadUri, long fileSize) {

        this.fileName = fileName;
        this.fileUri = fileUri;
        this.fileDownloadUri = fileDownloadUri;
        this.fileSize = fileSize;
    }

}