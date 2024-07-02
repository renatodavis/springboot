package renatodavis.com.pessoas.models;

import jakarta.persistence.*;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "venda_pedido")
public class VendaPedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataPedido = LocalDate.now();

    @ManyToOne
    @JoinColumn(name = "cliente_id", nullable = false)
    @NotNull
    private PessoaModel cliente;

    @Enumerated(EnumType.STRING)
    private StatusPedido statusPedido;

    public enum StatusPedido {
        ATENDIDO,
        CANCELADO,
        EM_ANDAMENTO,
        EM_DIGITACAO
    }

    public Boolean isValid() {
        return (this.cliente.getAtivo()) && (this.getDataPedido().isAfter(LocalDate.now()));
    }
}
