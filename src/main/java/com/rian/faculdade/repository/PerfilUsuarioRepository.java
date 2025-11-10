package com.rian.faculdade.repository;

import com.rian.faculdade.entity.PerfilUsuarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PerfilUsuarioRepository extends JpaRepository<PerfilUsuarioEntity, Long> {
    Optional<PerfilUsuarioEntity> findByUsuarioId(Long UsuarioId);
}
