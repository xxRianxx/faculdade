package com.rian.faculdade.repository;

import com.rian.faculdade.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<AlunoEntity, Long> {

    Optional<AlunoEntity> findByRa(String ra);

    Optional<AlunoEntity> findByPessoaId(Long pessoaId);

}
