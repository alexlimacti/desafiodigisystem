package com.digisystem.service;

import com.digisystem.model.EnderecoDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class CepServiceTest {

    @Autowired
    private CepService cepService;

    @Test
    public void cepServiceTest(){
        String cep = "48601-570";
        EnderecoDTO enderecoDTO = cepService.buscaEnderecoPorCep(cep);
        assertEquals(cep, enderecoDTO.getCep());
    }
}
