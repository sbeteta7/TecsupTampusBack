package com.tampusdev.tampus.persistence.repository;

import com.tampusdev.tampus.persistence.entities.AnuncioEtiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnuncioEtiquetaRepository extends JpaRepository<AnuncioEtiqueta,Long> {

    @Query("SELECT ae FROM AnuncioEtiqueta ae WHERE ae.id_anuncio.id_anuncio = :idAnuncio")
    List<AnuncioEtiqueta> findById_anuncio(@Param("idAnuncio") Integer idAnuncio);
}
