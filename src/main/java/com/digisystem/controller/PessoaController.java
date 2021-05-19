package com.digisystem.controller;

import com.digisystem.model.Pessoa;
import com.digisystem.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/pessoas")
public class PessoaController {

    @Autowired
    private PessoaService pessoaService;

    @GetMapping
    public ResponseEntity<?> getAllPessoas(){
        List<Pessoa> list = pessoaService.findAll();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<?> getPessoa(@PathVariable Long pessoaId){
        Pessoa pessoa = pessoaService.findById(pessoaId).orElseThrow(()-> new NullPointerException("Pessoa not found"));
        return ResponseEntity.ok(pessoa);
    }

    @PostMapping
    public ResponseEntity<Pessoa> postPessoa(@Valid @RequestBody Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoaService.save(pessoa));
    }

    @PutMapping("/{pessoaId}")
    public ResponseEntity<Pessoa> putPessoa(@PathVariable Long pessoaId,
                                            @RequestBody @Valid Pessoa pessoa){
        return ResponseEntity.status(HttpStatus.OK).body(pessoaService.update(pessoaId, pessoa));
    }

    @DeleteMapping("/{pessoaId}")
    public ResponseEntity<?> deletePessoa(@PathVariable long pessoaId){
        pessoaService.deleteById(pessoaId);
        return ResponseEntity.noContent().build();
    }
}
