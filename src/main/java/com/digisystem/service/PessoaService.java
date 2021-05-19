package com.digisystem.service;

import com.digisystem.model.Pessoa;
import com.digisystem.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    public Optional<Pessoa> findById(Long aLong) {
        return pessoaRepository.findById(aLong);
    }

    public void deleteById(Long aLong) {
        Pessoa pessoa = findById(aLong).orElseThrow(()-> new NullPointerException("Pessoa not found"));
        pessoaRepository.delete(pessoa);
    }

    public List<Pessoa> findAll() {
        return pessoaRepository.findAll();
    }

    public <S extends Pessoa> S save(S s) {
        return pessoaRepository.save(s);
    }

    public Pessoa update(Long id, Pessoa pessoa){
        Pessoa p = findById(id).orElseThrow(()-> new NullPointerException("Pessoa not found"));
        p.setName(pessoa.getName());
        return save(p);
    }

}
