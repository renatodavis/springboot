package renatodavis.com.pessoas.controle;

import org.springframework.web.bind.annotation.RestController;

import renatodavis.com.pessoas.modelo.PessoaModelo;
import renatodavis.com.pessoas.modelo.RespostaModelo;
import renatodavis.com.pessoas.servico.PessoaServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class PessoaControle {
	
	@Autowired
	private PessoaServico pessoaservico;
	
	@GetMapping("/listar")
	public Iterable<PessoaModelo> listar(){
		return pessoaservico.listar();
	}
	@DeleteMapping("/remover/{id}")
	public ResponseEntity<RespostaModelo> remover(@PathVariable long id){
		return pessoaservico.remover(id);
	}
	
	@PutMapping("/alterar")
	public ResponseEntity<?> alterar(@RequestBody PessoaModelo pessoa){
		return pessoaservico.cadastrarAlterar(pessoa,"alterar");
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrar(@RequestBody PessoaModelo pessoa){
		return pessoaservico.cadastrarAlterar(pessoa,"cadastrar");
	}
	
	@GetMapping("/")
	public String Rota() {
		return "API DE Pessoas";
	}
	
}
