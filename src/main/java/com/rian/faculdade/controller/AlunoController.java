package com.rian.faculdade.controller;

import com.rian.faculdade.Dtos.AlunoCreateDTO;
import com.rian.faculdade.Dtos.AlunoDTO;
import com.rian.faculdade.service.AlunoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    private final AlunoService alunoService;

    // Injeção via construtor
    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    // Endpoint para cadastrar aluno
    @PostMapping
    public ResponseEntity<AlunoDTO> create(@RequestBody AlunoCreateDTO dto) {
        AlunoDTO novoAluno = alunoService.create(dto);
        return ResponseEntity.ok(novoAluno);
    }

    // Endpoint para buscar por RA
    @GetMapping("/ra/{ra}")
    public ResponseEntity<AlunoDTO> findById(@PathVariable String ra) {
        AlunoDTO aluno = alunoService.findByRa(ra);
        return ResponseEntity.ok(aluno);
    }

}
