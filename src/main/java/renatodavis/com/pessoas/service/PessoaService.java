package renatodavis.com.pessoas.service;

import org.springframework.stereotype.Service;
import renatodavis.com.pessoas.exception.RegraDeNegocioException;
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

    public void remover(Long id) throws RegraDeNegocioException {
        PessoaModel pessoaAtualizada = pessoarepository.findById(id).get();
        pessoaAtualizada.ativo = false;
        validarStatus (pessoaAtualizada);
        pessoarepository.deleteById(id);
    }

    public PessoaModel cadastrar(PessoaModel pessoa) throws RegraDeNegocioException {
        return pessoarepository.save(pessoa);
    }

    public PessoaModel desativarPessoa(long id) throws RegraDeNegocioException{
        PessoaModel pessoaAtualizada = pessoarepository.findById(id).get();
        pessoaAtualizada.ativo = false;
        return pessoarepository.save(pessoaAtualizada);
    }

    public PessoaModel ativarPessoa(long id) throws RegraDeNegocioException{
        PessoaModel pessoaAtualizada = pessoarepository.findById(id).get();
        pessoaAtualizada.ativo = true;
        return pessoarepository.save(pessoaAtualizada);
    }

    protected PessoaModel validarStatus(PessoaModel pessoa) throws RegraDeNegocioException {
        if (!pessoa.ativo) {
            throw new RegraDeNegocioException("O status da pessoa está inativo! pessoa " + pessoa.nome);
        }
        return pessoa;
    }

    private PessoaModel validarLimiteCredito(PessoaModel pessoa, Double valor) throws RegraDeNegocioException{
        if (valor > pessoa.limiteCredito) {
            throw new RegraDeNegocioException("Limite de crédito excedido! " +
                    " " + pessoa.nome + " limite atual = " + pessoa.limiteCredito);
        }
        return pessoa;
    }
}
