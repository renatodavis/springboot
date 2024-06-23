package renatodavis.com.pessoas.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import renatodavis.com.pessoas.exception.RegraDeNegocioException;
import renatodavis.com.pessoas.models.PessoaModel;
import renatodavis.com.pessoas.service.PessoaService;

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

    @DeleteMapping("/excluir/{id}")
    public void remover(@PathVariable long id) throws RegraDeNegocioException {
        pessoaservice.remover(id);
    }

    @PutMapping
    public ResponseEntity<PessoaModel> alterar(@RequestBody PessoaModel pessoa) throws RegraDeNegocioException{
        return ResponseEntity.ok(pessoaservice.cadastrar(pessoa));
    }

    @PostMapping
    public ResponseEntity<PessoaModel> cadastrar(@RequestBody PessoaModel pessoa) throws RegraDeNegocioException{
        return ResponseEntity.ok(pessoaservice.cadastrar(pessoa));
    }

    @PutMapping("/desativar/{id}")
    public ResponseEntity<PessoaModel> desativarPessoa(@PathVariable long id) throws RegraDeNegocioException{
        return ResponseEntity.ok(pessoaservice.desativarPessoa(id));
    }

    @PutMapping("/ativar/{id}")
    public ResponseEntity<PessoaModel> ativarPessoa(@PathVariable long id) throws RegraDeNegocioException{
        return ResponseEntity.ok(pessoaservice.ativarPessoa(id));
    }
}
