package renatodavis.com.pessoas.service;

import org.springframework.stereotype.Service;
import renatodavis.com.pessoas.models.PessoaModel;
import renatodavis.com.pessoas.repository.PessoaRepository;

import java.util.List;

@Service
public class PessoaService {

    private final PessoaRepository pessoarepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoarepository = pessoaRepository;
    }

    public Iterable<PessoaModel> listar() {
        return pessoarepository.findAll();
    }


    public PessoaModel cadastrar(PessoaModel pessoa) {
        return pessoarepository.save(pessoa);
    }

	public void remover(Long id) {
		pessoarepository.deleteById(id);
	}
}
