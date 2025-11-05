package com.rian.faculdade.entity;

import jakarta.persistence.*;

@Entity
public class ProfessorEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private PessoaEntity pessoa;

    public PessoaEntity getPessoa() {
        return pessoa;
    }
}
