package renatodavis.com.pessoas.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import renatodavis.com.pessoas.exception.RegraDeNegocioException;
import renatodavis.com.pessoas.models.PessoaModel;
import renatodavis.com.pessoas.service.PessoaService;

import java.util.Optional;

@RestController
@RequestMapping("/api/pessoas")
public class PessoaResource {

    @Autowired
    private final PessoaService pessoaservice;

    public PessoaResource(PessoaService pessoaservice) {
        this.pessoaservice = pessoaservice;
    }

    @GetMapping
    public Iterable<PessoaModel> listar() {
        return pessoaservice.listar();
    }

    @GetMapping("/{id}")
    public Optional<PessoaModel> getCliente(@PathVariable long id) {
        return pessoaservice.getPessoa(id);
    }

    @DeleteMapping("/excluir/{id}")
    public void remover(@PathVariable long id) throws RegraDeNegocioException {
        pessoaservice.remover(id);
    }

    @PostMapping
    public ResponseEntity<PessoaModel> cadastrar(@RequestBody PessoaModel pessoa) throws RegraDeNegocioException {
        return ResponseEntity.ok(pessoaservice.cadastrar(pessoa));
    }

    @PutMapping("/alterar")
    public ResponseEntity<PessoaModel> alterarPessoa(@RequestBody PessoaModel pessoa) throws RegraDeNegocioException {
        return ResponseEntity.ok(pessoaservice.alterarPessoa(pessoa));
    }

    @PutMapping("/desativar/{id}")
    public ResponseEntity<PessoaModel> desativarPessoa(@PathVariable long id) throws RegraDeNegocioException {
        return ResponseEntity.ok(pessoaservice.desativarPessoa(id));
    }

    @PutMapping("/ativar/{id}")
    public ResponseEntity<PessoaModel> ativarPessoa(@PathVariable long id) throws RegraDeNegocioException {
        return ResponseEntity.ok(pessoaservice.ativarPessoa(id));
    }
}
