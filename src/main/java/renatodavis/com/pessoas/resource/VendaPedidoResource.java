package renatodavis.com.pessoas.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import renatodavis.com.pessoas.models.VendaPedido;
import renatodavis.com.pessoas.service.VendaPedidoService;

import java.util.Optional;

@RestController
@RequestMapping("/api/vendas/pedidos")
public class VendaPedidoResource {

    @Autowired
    VendaPedidoService vendaPedidoService;

    @GetMapping
    public Iterable<VendaPedido> listar() {
        return vendaPedidoService.getAllVendasPedidos();
    }

    @GetMapping("/{id}")
    public Optional<VendaPedido> getVendaPedisoById(@PathVariable long id) {
        return vendaPedidoService.getVendaPedidoById(id);
    }

}
