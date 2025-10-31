package com.rian.faculdade.Dtos;

import com.rian.faculdade.model.UsuarioModel;
import org.springframework.beans.BeanUtils;

public class UsuarioDTO {

    private long id;
    private String email;
    private String senha;
    private String status;

    public UsuarioDTO(UsuarioModel usuario) {
        BeanUtils.copyProperties(usuario, this);
    }

    public UsuarioDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
