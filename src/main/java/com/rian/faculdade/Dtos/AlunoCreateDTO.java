package com.rian.faculdade.Dtos;

public class AlunoCreateDTO {
    private PessoaDTO pessoa;
    private UsuarioCreateDTO usuario;

    public PessoaDTO getPessoa() {
        return pessoa;
    }

    public void setPessoa(PessoaDTO pessoa) {
        this.pessoa = pessoa;
    }

    public UsuarioCreateDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioCreateDTO usuario) {
        this.usuario = usuario;
    }
}
