package renatodavis.com.pessoas.service;

import org.springframework.stereotype.Service;
import renatodavis.com.pessoas.models.PessoaModel;
import renatodavis.com.pessoas.repository.PessoaRepository;

import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaRepository pessoarepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoarepository = pessoaRepository;
    }

    public Iterable<PessoaModel> listar() {
        return pessoarepository.findAll();
    }

    public void remover(Long id) {
        pessoarepository.deleteById(id);
    }

    public Optional<PessoaModel> cadastrar(PessoaModel pessoa) {
        if (validarstatus(pessoa)) {
            return Optional.of(pessoarepository.save(pessoa));
        }
        return Optional.empty();
    }

    private boolean validarstatus(PessoaModel pessoa) {
        return pessoa.ativo;
    }
}
