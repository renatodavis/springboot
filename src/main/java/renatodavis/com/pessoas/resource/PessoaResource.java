package renatodavis.com.pessoas.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @DeleteMapping("/{id}")
    public void remover(@PathVariable long id) {
        pessoaservice.remover(id);
    }

    @PutMapping
    public ResponseEntity<Optional<PessoaModel>> alterar(@RequestBody PessoaModel pessoa) {
        return ResponseEntity.ok(pessoaservice.cadastrar(pessoa));
    }

    @PostMapping
    public ResponseEntity<Optional<PessoaModel>> cadastrar(@RequestBody PessoaModel pessoa) {
        return ResponseEntity.ok(pessoaservice.cadastrar(pessoa));
    }
}
