package renatodavis.com.pessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import renatodavis.com.pessoas.models.VendaPedido;

@Repository
public interface VendaPedidoRepository extends JpaRepository<VendaPedido, Long> {
}
