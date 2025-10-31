package com.rian.faculdade.service;

import com.rian.faculdade.Dtos.PessoaDTO;
import com.rian.faculdade.model.PessoaModel;
import com.rian.faculdade.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<PessoaDTO> ListarTodos() {
        List<PessoaModel> usuarios = pessoaRepository.findAll();
        return usuarios.stream().map(PessoaDTO::new).toList();
    }

    public void inserir(PessoaDTO pessoa) {
        PessoaModel pessoaModel = new PessoaModel(pessoa);
        pessoaRepository.save(pessoaModel);
    }

    public PessoaDTO alterar(PessoaDTO pessoa) {
        PessoaModel pessoaModel = new PessoaModel(pessoa);
        return new PessoaDTO(pessoaRepository.save(pessoaModel));
    }

    public PessoaDTO encontrarPorId(Long id) {
        return new PessoaDTO(pessoaRepository.findById(id).get());
    }

    public void excluir(Long id) {
        PessoaModel pessoa = pessoaRepository.findById(id).get();
        pessoaRepository.delete(pessoa);
    }
}
