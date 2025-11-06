package com.rian.faculdade.repository;

import com.rian.faculdade.entity.PessoaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaEntity, Long> {
    Optional<PessoaEntity> findByCpf(String cpf);

}
