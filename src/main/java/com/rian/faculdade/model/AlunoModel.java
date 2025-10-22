package com.rian.faculdade.model;


import jakarta.persistence.*;

@Entity
public class AlunoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne
    @JoinColumn(name = "id_pessoa")
    private PessoaModel pessoa;
    private int ra;

    public PessoaModel getPessoa(){
        return pessoa;
    }
    public int getRa(){
        return ra;
    }
    public void setRa(int ra){
        this.ra = ra;
    }
}
