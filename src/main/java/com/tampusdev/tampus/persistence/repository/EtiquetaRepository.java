package com.tampusdev.tampus.persistence.repository;

import com.tampusdev.tampus.persistence.entities.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtiquetaRepository extends JpaRepository<Etiqueta,Long> {

}
