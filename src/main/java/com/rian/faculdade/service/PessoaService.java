package com.rian.faculdade.service;

import com.rian.faculdade.Dtos.PessoaDTO;
import com.rian.faculdade.entity.EnderecoEntity;
import com.rian.faculdade.entity.PessoaEntity;
import com.rian.faculdade.exceptions.BusinessException;
import com.rian.faculdade.repository.PessoaRepository;
import com.rian.faculdade.util.CpfUtils;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoService enderecoService;

    @Transactional
    public PessoaEntity create(PessoaDTO pessoaDTO) {
        // Validação datas no futuro
        if (pessoaDTO.getDataNascimento().isAfter(LocalDate.now())) {
            throw new BusinessException("Data de nascimento inválida.");
        }
        // validação de cfp valido.
        if (!CpfUtils.isValid(pessoaDTO.getCpf())) {
            throw new BusinessException("CPF inválido.");
        }

        //  Cria o endereço (chama a EnderecoService)
        EnderecoEntity endereco = enderecoService.create(pessoaDTO.getEndereco());

        //  Cria a pessoa
        PessoaEntity pessoa = new PessoaEntity();
        pessoa.setNome(pessoaDTO.getNome());
        pessoa.setCpf(pessoaDTO.getCpf());
        pessoa.setDataNascimento(pessoaDTO.getDataNascimento());
        pessoa.setEndereco(endereco);

        // 4. Salva no banco
        return pessoaRepository.save(pessoa);
    }
}
