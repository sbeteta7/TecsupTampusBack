package com.tampusdev.tampus.persistence.repository;

import com.tampusdev.tampus.persistence.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Usuario, Long>{
    Optional<Usuario> findUsuarioByEmail(String email);
}
