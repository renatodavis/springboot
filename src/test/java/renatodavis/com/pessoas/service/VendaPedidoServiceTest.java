package renatodavis.com.pessoas.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import renatodavis.com.pessoas.exception.RegraDeNegocioException;
import renatodavis.com.pessoas.models.PessoaModel;
import renatodavis.com.pessoas.models.VendaPedido;

import java.time.LocalDate;

@SpringBootTest
//@ExtendWith(SpringExtension.class)
public class VendaPedidoServiceTest {

    @Autowired
    VendaPedidoService vendaPedidoService;

    @Autowired
    PessoaService pessoaService;

    @Test
    public void testVendaPedidoCadastrar() throws RegraDeNegocioException {

        PessoaModel pessoa = new PessoaModel();
        pessoa.setId(1L);
        pessoa.setNome("Renato Davis");
        pessoa.setCpf("02148898906");
        pessoa.setLimiteCredito(1000.0);
        pessoa.setAtivo(true);

        LocalDate data_pedido = LocalDate.now();

        VendaPedido vendaPedido = new VendaPedido();
        vendaPedido.setId(1L);
        vendaPedido.setDataPedido(data_pedido);
        vendaPedido.setCliente(pessoa);
        vendaPedido.setStatusPedido(VendaPedido.StatusPedido.ATENDIDO);
    }

    @Test
    public void testVendaPedidoClienteInativoj() {

        PessoaModel pessoa = new PessoaModel();
        pessoa.setId(1L);
        pessoa.setNome("Renato Davis");
        pessoa.setCpf("02148898906");
        pessoa.setLimiteCredito(1000.0);
        pessoa.setAtivo(false);

        LocalDate data_pedido = LocalDate.now();

        VendaPedido vendaPedido = new VendaPedido();
        vendaPedido.setId(1L);
        vendaPedido.setDataPedido(data_pedido);
        vendaPedido.setCliente(pessoa);
        vendaPedido.setStatusPedido(VendaPedido.StatusPedido.ATENDIDO);
        Assertions.assertFalse(vendaPedido.isValid());
    }

    @Test
    public void testVendaPedidoClienteDataPedidMenorDataAtual() {
        PessoaModel pessoa = new PessoaModel();
        pessoa.setId(1L);
        pessoa.setNome("Renato Davis");
        pessoa.setCpf("02148898906");
        pessoa.setLimiteCredito(1000.0);
        pessoa.setAtivo(true); //cliente inativo

        LocalDate data_pedido = LocalDate.of(2024, 06, 30);

        VendaPedido vendaPedido = new VendaPedido();
        vendaPedido.setId(1L);
        vendaPedido.setDataPedido(data_pedido);
        vendaPedido.setCliente(pessoa);
        vendaPedido.setStatusPedido(VendaPedido.StatusPedido.ATENDIDO);
        Assertions.assertFalse(vendaPedido.isValid());
    }
}

