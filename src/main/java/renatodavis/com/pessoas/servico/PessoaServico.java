package renatodavis.com.pessoas.servico;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import renatodavis.com.pessoas.modelo.PessoaModelo;
import renatodavis.com.pessoas.modelo.RespostaModelo;
import renatodavis.com.pessoas.repositorio.PessoaRepositorio;

@Service
public class PessoaServico {

		@Autowired
		private PessoaRepositorio pessoarepositorio;
		
		@Autowired
		private RespostaModelo respostamodelo;
		
		public Iterable<PessoaModelo> listar(){
			return pessoarepositorio.findAll();
		}
		

		public ResponseEntity<?> cadastrar(PessoaModelo pessoa){
			if (pessoa.nome.equals("")) {
				respostamodelo.mensagem = "O nome da pessoa é obrigatório!";
				return new ResponseEntity<RespostaModelo>(respostamodelo,HttpStatus.BAD_REQUEST);
			} else if (pessoa.cpf.equals("")) {
				respostamodelo.mensagem = "O cpf da pessoa é obrigatório!";
				return new ResponseEntity<RespostaModelo>(respostamodelo,HttpStatus.BAD_REQUEST);
			} else {
				return new ResponseEntity<PessoaModelo>(pessoarepositorio.save(pessoa),HttpStatus.CREATED);
			}
		}
		
}
