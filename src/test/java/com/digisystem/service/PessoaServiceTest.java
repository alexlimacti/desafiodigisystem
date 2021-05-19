package com.digisystem.service;

import com.digisystem.model.Pessoa;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@SpringBootTest
@Transactional
public class PessoaServiceTest {

    @Resource
    private PessoaService pessoaService;

    Pessoa pessoa;

    @Test
    public void verificaObjetoSalvo(){
        pessoa = new Pessoa();
        pessoa.setName("Simbora");
        Pessoa pessoa2 = pessoaService.save(pessoa);
        assertEquals(pessoa.getName(),pessoa2.getName());
    }

    @Test
    public void verificaObjetoExcluido(){
        pessoa = new Pessoa();
        pessoa.setName("Simbora");
        Pessoa pessoa2 = pessoaService.save(pessoa);
        pessoaService.deleteById(pessoa2.getId());
        assertNull(pessoaService.findById(pessoa2.getId()).orElse(null));
    }
}
