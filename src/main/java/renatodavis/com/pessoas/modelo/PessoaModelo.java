package renatodavis.com.pessoas.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name ="Pessoa")
@Getter
@Setter
public class PessoaModelo {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    public Long id;
    public String nome;
    public String cpf;
}
