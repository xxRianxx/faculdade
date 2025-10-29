package com.rian.faculdade.model;


import com.rian.faculdade.Dtos.UsuarioDTO;
import jakarta.persistence.*;
import org.springframework.beans.BeanUtils;

import java.util.Objects;

@Entity
@Table(name = "USUARIO")
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    private String email;
    @Column(nullable = false)
    private String senha;
    @Column(nullable = false)
    private String status;



    public String getEmail(){
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getStatus(){
        return status;
    }

    public void setEmail(String email){
        this.email = email;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    public void setStatus(String status){
        this.status = status;
    }

    public UsuarioModel(UsuarioDTO usuario){
        BeanUtils.copyProperties(usuario,this);
    }

    public UsuarioModel(){}


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioModel that = (UsuarioModel) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}
