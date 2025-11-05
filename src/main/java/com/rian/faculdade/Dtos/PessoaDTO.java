package com.rian.faculdade.Dtos;

import java.time.LocalDate;

public class PessoaDTO {

    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private UsuarioCreateDTO usuario;
    private EnderecoDTO endereco;

    public PessoaDTO() {
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public UsuarioCreateDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioCreateDTO usuario) {
        this.usuario = usuario;
    }

    public EnderecoDTO getEndereco() {
        return endereco;
    }

    public void setEndereco(EnderecoDTO endereco) {
        this.endereco = endereco;
    }
}
