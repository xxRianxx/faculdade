package com.rian.faculdade.service;

import com.rian.faculdade.Dtos.AlunoCreateDTO;
import com.rian.faculdade.Dtos.AlunoDTO;
import com.rian.faculdade.entity.AlunoEntity;
import com.rian.faculdade.entity.PessoaEntity;
import com.rian.faculdade.entity.UsuarioEntity;
import com.rian.faculdade.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepo;

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private UsuarioService usuarioService;

    @Transactional
    public AlunoDTO create(AlunoCreateDTO dto) {
        // Cria a pessoa (PessoaService cuida do endereço e validações)
        PessoaEntity pessoa = pessoaService.create(dto.getPessoa());

        // Cria usuário
        UsuarioEntity usuario = usuarioService.create(dto.getUsuario());

        // Cria aluno
        AlunoEntity aluno = new AlunoEntity();
        aluno.setPessoa(pessoa);
        aluno.setUsuario(usuario);
        aluno.setRa(generateRa());

        // Salva aluno (cascade salva usuário se configurado na entidade)
        AlunoEntity saved = alunoRepo.save(aluno);

        // Retorna DTO
        return mapperToDto(saved);
    }

    private String generateRa() {
        return "RA" + System.currentTimeMillis();
    }

    private AlunoDTO mapperToDto(AlunoEntity aluno) {
        AlunoDTO dto = new AlunoDTO();
        dto.setId(aluno.getId());
        dto.setRa(aluno.getRa());
        dto.setNomePessoa(aluno.getPessoa().getNome());
        dto.setEmailUsuario(aluno.getUsuario().getEmail());
        return dto;
    }

    @Transactional
    public AlunoDTO findByRa(String ra) {
        return alunoRepo.findByRa(ra)
                .map(this::mapperToDto) // converte AlunoEntity para DTO
                .orElseThrow(() -> new RuntimeException("Aluno não encontrado"));
    }
}
