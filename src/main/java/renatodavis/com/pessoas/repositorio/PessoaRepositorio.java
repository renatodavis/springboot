package renatodavis.com.pessoas.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.stereotype.Repository;

import renatodavis.com.pessoas.modelo.PessoaModelo;

@Repository
public interface PessoaRepositorio extends CrudRepository<PessoaModelo, Long>{

}
