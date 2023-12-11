package com.tampusdev.tampus.persistence.repository;

import com.tampusdev.tampus.persistence.entities.Anuncio;
import com.tampusdev.tampus.persistence.entities.AnuncioEtiqueta;
import com.tampusdev.tampus.persistence.entities.AnuncioFiles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnuncioFilesRepository extends JpaRepository<AnuncioFiles,Long> {
    @Query("SELECT af FROM AnuncioFiles af WHERE af.id_anuncio.id_anuncio = :idAnuncio")
    List<AnuncioFiles> findById_anuncio(@Param("idAnuncio") Integer idAnuncio);
}
