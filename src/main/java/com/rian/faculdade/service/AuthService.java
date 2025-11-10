package com.rian.faculdade.service;

import com.rian.faculdade.Dtos.LoginRequestDTO;
import com.rian.faculdade.Dtos.LoginResponseDTO;
import com.rian.faculdade.entity.PerfilUsuarioEntity;
import com.rian.faculdade.entity.UsuarioEntity;
import com.rian.faculdade.repository.PerfilUsuarioRepository;
import com.rian.faculdade.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AuthService {

    @Autowired
    private UsuarioRepository usuarioRepository;
    @Autowired
    private PerfilUsuarioRepository perfilUsuarioRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    public LoginResponseDTO login(LoginRequestDTO request) {
        UsuarioEntity usuario = usuarioRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new RuntimeException("Usuario não encontrado."));
        {
            if (!passwordEncoder.matches(request.getSenha(), usuario.getSenha())) {
                throw new RuntimeException("Senha incorreta.");
            }
        }
        PerfilUsuarioEntity perfilUsuario = perfilUsuarioRepository.findByUsuarioId(usuario.getId())
                .orElseThrow(() -> new RuntimeException("Perfil não encontrado para este usuário."));

        return new LoginResponseDTO(
                perfilUsuario.getPerfil().getDescricao(),
                usuario.getStatus()
        );
    }
}
