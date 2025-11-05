package com.rian.faculdade.service;

import com.rian.faculdade.Dtos.UsuarioCreateDTO;
import com.rian.faculdade.entity.UsuarioEntity;
import com.rian.faculdade.exceptions.BusinessException;
import com.rian.faculdade.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    @Autowired
    private UsuarioRepository repo;
    private final PasswordEncoder encoder = new BCryptPasswordEncoder();

    public UsuarioEntity create(UsuarioCreateDTO dto) {
        if (repo.existsByEmail(dto.getEmail()))
            throw new BusinessException("Email já existe");

        UsuarioEntity u = new UsuarioEntity();
        u.setEmail(dto.getEmail());
        u.setSenha(encoder.encode(dto.getSenha()));

        // Definindo status padrão para não quebrar o NOT NULL
        u.setStatus("ATIVO"); // ou o valor que fizer sentido no seu projeto

        return repo.save(u);
    }

}
