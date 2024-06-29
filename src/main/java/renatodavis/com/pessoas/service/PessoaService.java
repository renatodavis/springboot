package renatodavis.com.pessoas.service;

import org.springframework.stereotype.Service;
import renatodavis.com.pessoas.exception.RegraDeNegocioException;
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
    public Optional<PessoaModel> getPessoa(long id){
        return pessoarepository.findById(id);
    }

    public void remover(Long id) throws RegraDeNegocioException {
        PessoaModel pessoaAtualizada = pessoarepository.findById(id).get();
        validarStatus (pessoaAtualizada);
        pessoarepository.deleteById(id);
    }

    public PessoaModel cadastrar(PessoaModel pessoa) throws RegraDeNegocioException {
        return pessoarepository.save(pessoa);
    }

    public PessoaModel alterarPessoa(PessoaModel pessoa) throws RegraDeNegocioException{
        PessoaModel pessoaAtualizada = pessoarepository.findById(pessoa.id).get();
        if (!pessoaAtualizada.equals(null)){
            pessoarepository.save(pessoa);
        }
        return pessoa;
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
            throw new RegraDeNegocioException("O status da pessoa está inativo!");
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
