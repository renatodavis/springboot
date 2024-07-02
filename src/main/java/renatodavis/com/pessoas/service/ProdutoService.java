package renatodavis.com.pessoas.service;

import org.springframework.stereotype.Service;
import renatodavis.com.pessoas.models.ProdutoModel;
import renatodavis.com.pessoas.repository.ProdutoRepository;

import java.util.Optional;

@Service
public class ProdutoService {
    private final ProdutoRepository produtorepository;

    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtorepository = produtoRepository;
    }

    public Iterable<ProdutoModel> getAllProdutosModels() {
        return produtorepository.findAll();
    }

    public Optional<ProdutoModel> getProdutoById(Long id) {
        return produtorepository.findById(id);
    }
}
