package com.digisystem;

import com.digisystem.model.Pessoa;
import com.digisystem.repository.PessoaRepository;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
class DigisystemApplicationTests {

    @Test
    void contextLoads() {
    }

}
