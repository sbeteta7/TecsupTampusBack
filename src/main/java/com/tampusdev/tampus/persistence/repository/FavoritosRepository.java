package com.tampusdev.tampus.persistence.repository;

import com.tampusdev.tampus.persistence.entities.FavoritosEntity;
import com.tampusdev.tampus.persistence.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoritosRepository extends JpaRepository<FavoritosEntity,Integer> {

    List<FavoritosEntity> findByIdUsuario(Usuario usuario);
}