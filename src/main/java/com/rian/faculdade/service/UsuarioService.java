package com.rian.faculdade.service;


import com.rian.faculdade.model.UsuarioModel;
import com.rian.faculdade.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    // cadastrar um usuário
    public UsuarioModel cadastrarUsuario(UsuarioModel usuario){
        Optional<UsuarioModel> existente = usuarioRepository.findByEmail(usuario.getEmail());
        if(existente.isPresent()){
            throw new RuntimeException("Email já cadastrado!");
        }
        return usuarioRepository.save(usuario);
    }

    // login de um usuário
    public UsuarioModel login(String email, String senha){
        Optional<UsuarioModel> usuario = usuarioRepository.findByEmailAndSenha(email,senha);
        return usuario.orElseThrow(()-> new RuntimeException("Email ou senha icorretos!"));
    }
}
