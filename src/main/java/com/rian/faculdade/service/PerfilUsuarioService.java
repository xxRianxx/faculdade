package com.rian.faculdade.service;

import com.rian.faculdade.entity.PerfilEntity;
import com.rian.faculdade.entity.PerfilUsuarioEntity;
import com.rian.faculdade.entity.UsuarioEntity;
import com.rian.faculdade.repository.PerfilRepository;
import com.rian.faculdade.repository.PerfilUsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PerfilUsuarioService {

    @Autowired
    private PerfilRepository perfilRepo;

    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepo;

    public void atribuirPerfil(UsuarioEntity usuario, String descricaoPerfil) {
        PerfilEntity perfil = perfilRepo.findByDescricao(descricaoPerfil)
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado: " + descricaoPerfil));

        PerfilUsuarioEntity perfilUsuario = new PerfilUsuarioEntity();
        perfilUsuario.setPerfil(perfil);
        perfilUsuario.setUsuario(usuario);

        perfilUsuarioRepo.save(perfilUsuario);
    }
}

