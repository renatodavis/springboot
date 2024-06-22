package renatodavis.com.pessoas.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import renatodavis.com.pessoas.models.PessoaModel;
import renatodavis.com.pessoas.repository.PessoaRepository;

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

    public PessoaModel cadastrar(PessoaModel pessoa) {
        return pessoarepository.save(pessoa);
    }

    public PessoaModel desativarPessoa(long id) {
        PessoaModel pessoaAtualizada = pessoarepository.findById(id).get();
        pessoaAtualizada.ativo = false;
        return pessoarepository.save(pessoaAtualizada);
    }

    public PessoaModel ativarPessoa(long id) {
        PessoaModel pessoaAtualizada = pessoarepository.findById(id).get();
        pessoaAtualizada.ativo = true;
        return pessoarepository.save(pessoaAtualizada);
    }

    private PessoaModel validarStatus(PessoaModel pessoa) {
        if (!pessoa.ativo) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Não foi possível salvar " +
                    "o cadastro da pessoa " + pessoa.nome);
        }
        return pessoa;
    }

    private PessoaModel validarLimiteCredito(PessoaModel pessoa, Double valor) {
        if (valor > pessoa.limiteCredito) {
            throw new ResponseStatusException(HttpStatus.BAD_GATEWAY, "Limite de crédito excedido! " +
                    " " + pessoa.nome + " limite atual = " + pessoa.limiteCredito);
        }
        return pessoa;
    }
}
