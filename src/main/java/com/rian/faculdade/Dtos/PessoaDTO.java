package com.rian.faculdade.Dtos;

import com.rian.faculdade.model.EnderecoEntity;
import com.rian.faculdade.model.PessoaEntity;
import com.rian.faculdade.model.UsuarioEntity;
import org.springframework.beans.BeanUtils;

import java.util.Date;

public class PessoaDTO {
    private long id;

    private String nome;

    private String cpf;

    private Date dataNascimento;

    private UsuarioEntity usuario;
    private EnderecoEntity endereco;

    public PessoaDTO() {
    }

    public PessoaDTO(PessoaEntity pessoa) {
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

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public EnderecoEntity getEndereco() {
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

    public void setEndereco(EnderecoEntity endereco) {
        this.endereco = endereco;
    }
}
