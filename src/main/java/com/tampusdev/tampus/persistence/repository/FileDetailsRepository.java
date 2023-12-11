package com.tampusdev.tampus.persistence.repository;

import com.tampusdev.tampus.persistence.entities.FileDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileDetailsRepository extends JpaRepository<FileDetails, Integer>{
}
