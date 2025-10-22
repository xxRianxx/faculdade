package com.rian.faculdade.model;


import jakarta.persistence.*;

import java.util.Date;

@Entity
public class PessoaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String cpf;
    private Date dataNascimento;
    @OneToOne
    @JoinColumn(name = "usuario")
    private UsuarioModel usuario;
    @OneToOne
    @JoinColumn(name = "endereco")
    private EnderecoModel endereco;

    public String getNome(){
        return nome;
    }

    public String getCpf(){
        return cpf;
    }
    public Date getDataNascimento(){
        return dataNascimento;
    }
    public UsuarioModel getUsuario(){
        return usuario;
    }

    public EnderecoModel getEndereco(){
        return endereco;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCpf(String cpf){
        this.cpf = cpf;
    }
    public void setDataNascimento(Date dataNascimento){
        this.dataNascimento = dataNascimento;
    }

    public void setEndereco(EnderecoModel endereco){
        this.endereco = endereco;
    }

}
