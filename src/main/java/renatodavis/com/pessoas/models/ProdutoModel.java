package renatodavis.com.pessoas.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "produto")
public class ProdutoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long id;
    public String descricao_completa;
    public String descricao_resumida;
    public Double valor_unitario;
    public Double valor_perc_lucro;
    public Double valor_venda_bruto;
    public Double valor_venda_com_desconto;
    public Date data_ini_desconto;
    public Date data_fim_desconto;
}
