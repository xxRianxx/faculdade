package com.rian.faculdade.configuration;

import com.rian.faculdade.entity.PerfilEntity;
import com.rian.faculdade.repository.PerfilRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class PerfilDataLoader {

    private final PerfilRepository perfilRepository;

    public PerfilDataLoader(PerfilRepository perfilRepository) {
        this.perfilRepository = perfilRepository;
    }

    @PostConstruct
    public void init() {
        criarPerfilSeNaoExistir("ALUNO");
        criarPerfilSeNaoExistir("PROFESSOR");
        criarPerfilSeNaoExistir("COORDENADOR");
    }

    private void criarPerfilSeNaoExistir(String descricao) {
        perfilRepository.findByDescricao(descricao)
                .orElseGet(() -> {
                    PerfilEntity perfil = new PerfilEntity();
                    perfil.setDescricao(descricao);
                    return perfilRepository.save(perfil);
                });
    }
}
