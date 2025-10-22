package com.rian.faculdade.model;


import jakarta.persistence.*;

@Entity
public class PerfilUsuarioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private PerfilModel perfil;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioModel usuario;

    public PerfilModel getPerfil(){
        return perfil;
    }
    public UsuarioModel getUsuario(){
        return usuario;
    }

    public void setPerfil(PerfilModel perfil){
        this.perfil = perfil;
    }

}
