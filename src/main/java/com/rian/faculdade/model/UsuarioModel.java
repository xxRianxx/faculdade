package com.rian.faculdade.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class UsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String email;
    private String senha;
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
}
