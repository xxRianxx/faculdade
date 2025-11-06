package com.rian.faculdade.service;

import com.rian.faculdade.Dtos.EnderecoDTO;
import com.rian.faculdade.entity.EnderecoEntity;
import com.rian.faculdade.repository.EnderecoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EnderecoService {
    @Autowired
    private EnderecoRepository enderecoRepository;

    @Transactional
    public EnderecoEntity create(EnderecoDTO enderecoDTO) {

        // Validações simples
        if (enderecoDTO.getCidade() == null || enderecoDTO.getCidade().isBlank()) {
            throw new IllegalArgumentException("A cidade não pode ser vazia");
        }

        if (enderecoDTO.getEstado() == null || enderecoDTO.getEstado().length() != 2) {
            throw new IllegalArgumentException("O estado deve conter apenas 2 letras (ex: MG, SP)");
        }

        // Converter o DTO em Entity
        EnderecoEntity endereco = new EnderecoEntity();
        endereco.setLogradouro(enderecoDTO.getLogradouro());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setNumero(enderecoDTO.getNumero());
        endereco.setComplemento(enderecoDTO.getComplemento());
        endereco.setEstado(enderecoDTO.getEstado());
        endereco.setBairro(enderecoDTO.getBairro());

        // Salvar no banco
        return enderecoRepository.save(endereco);
    }
}
