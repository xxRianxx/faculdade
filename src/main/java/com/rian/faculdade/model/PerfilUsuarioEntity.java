package com.rian.faculdade.model;

import jakarta.persistence.*;

@Entity
public class PerfilUsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    @JoinColumn(name = "id_perfil")
    private PerfilEntity perfil;
    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private UsuarioEntity usuario;

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
