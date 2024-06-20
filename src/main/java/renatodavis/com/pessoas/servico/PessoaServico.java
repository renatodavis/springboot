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
		

		public ResponseEntity<?> cadastrarAlterar(PessoaModelo pessoa, String acao){
			
			if (pessoa.nome.equals("")) {
				respostamodelo.mensagem = "O nome da pessoa é obrigatório!";
				return new ResponseEntity<RespostaModelo>(respostamodelo,HttpStatus.BAD_REQUEST);
			} else if (pessoa.cpf.equals("")) {
				respostamodelo.mensagem = "O cpf da pessoa é obrigatório!";
				return new ResponseEntity<RespostaModelo>(respostamodelo,HttpStatus.BAD_REQUEST);
			} else {
				if (acao.equals("cadastrar"))
					return new ResponseEntity<PessoaModelo>(pessoarepositorio.save(pessoa),HttpStatus.CREATED);
				else if (acao.equals("alterar")){
					return new ResponseEntity<PessoaModelo>(pessoarepositorio.save(pessoa),HttpStatus.OK);
				}
			}
			return null;
		}
		
		public ResponseEntity<RespostaModelo> remover(long id){
			pessoarepositorio.deleteById(id);
			
			respostamodelo.mensagem = "Pessoa foi excluída com sucesso!";
			return new ResponseEntity<RespostaModelo>(respostamodelo,HttpStatus.OK);
		}
}
