package com.rian.faculdade.model;

import jakarta.persistence.*;

@Entity
public class ProfessorModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private PessoaModel pessoa;

    public PessoaModel getPessoa(){
        return pessoa;
    }
}
