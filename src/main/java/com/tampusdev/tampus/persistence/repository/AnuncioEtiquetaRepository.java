package com.tampusdev.tampus.persistence.repository;

import com.tampusdev.tampus.persistence.entities.AnuncioEtiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnuncioEtiquetaRepository extends JpaRepository<AnuncioEtiqueta,Long> {

}
