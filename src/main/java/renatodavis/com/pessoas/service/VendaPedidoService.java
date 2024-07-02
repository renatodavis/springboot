package renatodavis.com.pessoas.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import renatodavis.com.pessoas.models.VendaPedido;
import renatodavis.com.pessoas.repository.VendaPedidoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class VendaPedidoService {

    @Autowired
    private final VendaPedidoRepository vendaPedidoRepository;

    public VendaPedidoService(VendaPedidoRepository vendaPedidoRepository) {
        this.vendaPedidoRepository = vendaPedidoRepository;
    }

    public List<VendaPedido> getAllVendasPedidos() {
        return vendaPedidoRepository.findAll();
    }

    public Optional<VendaPedido> getVendaPedidoById(Long id) {
        return vendaPedidoRepository.findById(id);
    }

    public void cadastrar(VendaPedido vendaPedido) {
        vendaPedidoRepository.save(vendaPedido);
    }

    public void remover(VendaPedido vendaPedido) {
        vendaPedidoRepository.delete(vendaPedido);
    }
}
