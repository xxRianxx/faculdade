package com.rian.faculdade.service;


import com.rian.faculdade.Dtos.UsuarioDTO;
import com.rian.faculdade.model.UsuarioModel;
import com.rian.faculdade.repository.UsuarioRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    @Autowired
   private UsuarioRepository usuarioRepository;

    public List<UsuarioDTO> listarTodos(){
       List<UsuarioModel> usuarios = usuarioRepository.findAll();
       return usuarios.stream().map(UsuarioDTO::new).toList();
    }

    public void inserir(UsuarioDTO usuario) {
        UsuarioModel usuarioModel = new UsuarioModel(usuario);

        usuarioRepository.save(usuarioModel);
    }

    public UsuarioDTO alterar(UsuarioDTO usuario){
        UsuarioModel usuarioModel = new UsuarioModel(usuario);
        return new UsuarioDTO(usuarioRepository.save(usuarioModel));
    }
public UsuarioDTO buscarPorId(Long id){
       return new UsuarioDTO(usuarioRepository.findById(id).get());
}
    public void excluir(Long id){
        UsuarioModel usuario = usuarioRepository.findById(id).get();
        usuarioRepository.delete(usuario);
    }
}
