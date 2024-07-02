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
        Optional<PessoaModel> pessoaAtualizada = pessoarepository.findById(pessoa.getId());
        if (pessoaAtualizada.isPresent()){
            pessoarepository.save(pessoa);
        }
        return pessoa;
    }

    public PessoaModel desativarPessoa(long id) throws RegraDeNegocioException{
        Optional<PessoaModel> pessoaAtualizada = pessoarepository.findById(id);
        pessoaAtualizada.ifPresent(pessoaModel -> pessoaModel.setAtivo(false));
        return pessoarepository.save(pessoaAtualizada.get());
    }

    public PessoaModel ativarPessoa(long id) throws RegraDeNegocioException{
        Optional<PessoaModel> pessoaAtualizada = pessoarepository.findById(id);
        pessoaAtualizada.ifPresent(pessoaModel -> pessoaModel.setAtivo(true));
        return pessoarepository.save(pessoaAtualizada.get());
    }

    protected PessoaModel validarStatus(PessoaModel pessoa) throws RegraDeNegocioException {
        if (!pessoa.getAtivo()) {
            throw new RegraDeNegocioException("O status da pessoa está inativo!");
        }
        return pessoa;
    }

    private PessoaModel validarLimiteCredito(PessoaModel pessoa, Double valor) throws RegraDeNegocioException{
        if (valor > pessoa.getLimiteCredito()) {
            throw new RegraDeNegocioException("Limite de crédito excedido! " +
                    " " + pessoa.getNome() + " limite atual = " + pessoa.getLimiteCredito());
        }
        return pessoa;
    }
}
