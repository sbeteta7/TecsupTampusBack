package com.tampusdev.tampus.persistence.repository;

import com.tampusdev.tampus.controller.models.AnuncioResponse;
import com.tampusdev.tampus.persistence.entities.Anuncio;
import com.tampusdev.tampus.persistence.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import javax.swing.text.html.Option;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Repository
public interface AnuncioRepository extends JpaRepository<Anuncio,Integer> {


        @Query("SELECT a FROM Anuncio a WHERE a.id_user = :user")
        List<Anuncio> findAnuncioById_user(Usuario user);

        @Query("SELECT a FROM Anuncio a " +
                "WHERE (:precioMin IS NULL OR a.precio >= :precioMin) " +
                "  AND (:precioMax IS NULL OR a.precio <= :precioMax) " +
                "  AND (:tipoEspacio IS NULL OR a.tipo_espacio = :tipoEspacio) " +
                "  AND (:numHab IS NULL OR a.num_hab = :numHab) " +
                "  AND (:numCama IS NULL OR a.num_cama = :numCama) " +
                "  AND (:dimensiones IS NULL OR a.dimensiones = :dimensiones)")
        List<Anuncio> findByFiltros(
                @Param("precioMin") BigDecimal precioMin,
                @Param("precioMax") BigDecimal precioMax,
                @Param("tipoEspacio") String tipoEspacio,
                @Param("numHab") int numHab,
                @Param("numCama") int numCama,
                @Param("dimensiones") Integer dimensiones
        );
}
