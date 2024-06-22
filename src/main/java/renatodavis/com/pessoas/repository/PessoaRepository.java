package renatodavis.com.pessoas.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import renatodavis.com.pessoas.models.PessoaModel;

@Repository
public interface PessoaRepository extends CrudRepository<PessoaModel, Long>{

}
