package com.rian.faculdade.Dtos;

import com.rian.faculdade.model.EnderecoModel;
import com.rian.faculdade.model.PessoaModel;
import com.rian.faculdade.model.UsuarioModel;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class PessoaDTO {
    private long id;

    private String nome;

    private String cpf;

    private Date dataNascimento;

    private UsuarioModel usuario;
    private EnderecoModel endereco;

    public PessoaDTO() {
    }

    public PessoaDTO(PessoaModel pessoa) {
        BeanUtils.copyProperties(pessoa, this);
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public EnderecoModel getEndereco() {
        return endereco;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEndereco(EnderecoModel endereco) {
        this.endereco = endereco;
    }
}
