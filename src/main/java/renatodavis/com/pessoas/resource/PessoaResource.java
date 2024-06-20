package renatodavis.com.pessoas.resource;

import org.hibernate.query.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import renatodavis.com.pessoas.models.PessoaModel;
import renatodavis.com.pessoas.service.PessoaService;


@RestController("/api/pessoas")
public class PessoaResource {

    private final PessoaService pessoaservice;

    public PessoaResource(PessoaService pessoaservice) {
        this.pessoaservice = pessoaservice;
    }

    @GetMapping
    public Iterable<PessoaModel> listar() {
        return pessoaservice.listar();
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable long id) {
        pessoaservice.remover(id);
    }

    @PutMapping
    public ResponseEntity<PessoaModel> alterar(@RequestBody PessoaModel pessoa) {
        return ResponseEntity.ok(pessoaservice.cadastrar(pessoa));
    }

    @PostMapping
    public ResponseEntity<PessoaModel> cadastrar(@RequestBody PessoaModel pessoa) {
        return ResponseEntity.ok(pessoaservice.cadastrar(pessoa));
    }
}
