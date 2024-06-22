package renatodavis.com.pessoas.models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name ="Pessoa")
public class PessoaModel {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public String cpf;
    public Boolean ativo = true;
    public Double limiteCredito = 0.0;

}
