package renatodavis.com.pessoas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import renatodavis.com.pessoas.models.PessoaModel;

@Repository
public interface PessoaRepository extends JpaRepository<PessoaModel, Long> {

}
