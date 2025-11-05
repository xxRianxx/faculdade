package com.rian.faculdade.service;

import com.rian.faculdade.Dtos.AlunoCreateDTO;
import com.rian.faculdade.Dtos.AlunoDTO;
import com.rian.faculdade.Dtos.EnderecoDTO;
import com.rian.faculdade.entity.AlunoEntity;
import com.rian.faculdade.entity.EnderecoEntity;
import com.rian.faculdade.entity.PessoaEntity;
import com.rian.faculdade.entity.UsuarioEntity;
import com.rian.faculdade.repository.AlunoRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    private final AlunoRepository alunoRepo;

    public AlunoService(AlunoRepository alunoRepo) {
        this.alunoRepo = alunoRepo;
    }

    @Transactional
    public AlunoDTO create(AlunoCreateDTO dto) {
        // Pessoa
        PessoaEntity pessoa = new PessoaEntity();
        pessoa.setNome(dto.getPessoa().getNome());
        pessoa.setCpf(dto.getPessoa().getCpf());
        pessoa.setDataNascimento(dto.getPessoa().getDataNascimento());

        // Endereço
        if (dto.getPessoa().getEndereco() != null) {
            EnderecoDTO eDto = dto.getPessoa().getEndereco();
            EnderecoEntity endereco = new EnderecoEntity();
            endereco.setLogradouro(eDto.getLogradouro());
            endereco.setCidade(eDto.getCidade());
            endereco.setNumero(eDto.getNumero());
            endereco.setComplemento(eDto.getComplemento());
            endereco.setEstado(eDto.getEstado());
            endereco.setBairro(eDto.getBairro());
            pessoa.setEndereco(endereco);
        }

        // Usuário
        UsuarioEntity usuario = new UsuarioEntity();
        usuario.setEmail(dto.getUsuario().getEmail());
        usuario.setSenha(dto.getUsuario().getSenha());
        usuario.setStatus("ATIVO");

        // Aluno
        AlunoEntity aluno = new AlunoEntity();
        aluno.setPessoa(pessoa);
        aluno.setUsuario(usuario);
        aluno.setRa(generateRa());

        // Salva tudo (cascade salva pessoa, endereço e usuário)
        AlunoEntity saved = alunoRepo.save(aluno);

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
}
