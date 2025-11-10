package com.rian.faculdade.entity;

import jakarta.persistence.*;

@Entity
public class PerfilUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_perfil", nullable = false)
    private PerfilEntity perfil;
    @ManyToOne
    @JoinColumn(name = "id_usuario", nullable = false)
    private UsuarioEntity usuario;

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public PerfilEntity getPerfil() {
        return perfil;
    }

    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setPerfil(PerfilEntity perfil) {
        this.perfil = perfil;
    }

}
