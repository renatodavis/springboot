package renatodavis.com.pessoas.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import renatodavis.com.pessoas.models.PessoaModel;


public class PessoaServiceTest {

    @Autowired
    private  PessoaService pessoaService;

    @Test
    public void testValidarStatusError() {

        PessoaModel pessoa = new PessoaModel();
        pessoa.setId(13L);
        pessoa.setNome("renato");
        pessoa.setAtivo(false);
        pessoa.setCpf("02148898906");
        pessoa.setLimiteCredito(1.1);

        Assertions.assertThrows(Exception.class, () -> pessoaService.validarStatus(pessoa));
    }
}
