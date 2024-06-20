package renatodavis.com.pessoas.controle;

import org.springframework.web.bind.annotation.RestController;

import renatodavis.com.pessoas.modelo.PessoaModelo;
import renatodavis.com.pessoas.servico.PessoaServico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@RestController
public class PessoaControle {
	
	@Autowired
	private PessoaServico pessoaservico;
	
	@GetMapping("/listar")
	public Iterable<PessoaModelo> listar(){
		return pessoaservico.listar();
	}
	
	@PostMapping("/cadastrar")
	public ResponseEntity<?> cadastrar(@RequestBody PessoaModelo pessoa){
		return pessoaservico.cadastrar(pessoa);
	}
	
	@GetMapping("/")
	public String Rota() {
		return "API DE Pessoas";
	}
	
}
