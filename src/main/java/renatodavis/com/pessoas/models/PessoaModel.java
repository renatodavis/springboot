package renatodavis.com.pessoas.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
}
