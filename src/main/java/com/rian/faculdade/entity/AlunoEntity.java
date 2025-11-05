package com.rian.faculdade.entity;

import jakarta.persistence.*;

@Entity
public class AlunoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private PessoaEntity pessoa;
    private int ra;

    public PessoaEntity getPessoa() {
        return pessoa;
    }

    public int getRa() {
        return ra;
    }

    public void setRa(int ra) {
        this.ra = ra;
    }
}
