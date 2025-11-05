package com.rian.faculdade.entity;

import com.rian.faculdade.Dtos.PessoaDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Date;
import java.util.Objects;

@Entity
public class PessoaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(nullable = false)
    private String nome;
    @Column(nullable = false, unique = true)
    private String cpf;
    @Column(nullable = false)
    private Date dataNascimento;
    @OneToOne
    @JoinColumn(name = "usuario")
    private UsuarioEntity usuario;
    @OneToOne
    @JoinColumn(name = "endereco")
    private EnderecoEntity endereco;

    public PessoaEntity() {
    }

    public PessoaEntity(PessoaDTO pessoa) {
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

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        PessoaEntity that = (PessoaEntity) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
