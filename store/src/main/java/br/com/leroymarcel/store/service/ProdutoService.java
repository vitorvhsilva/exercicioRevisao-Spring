package br.com.leroymarcel.store.service;

import br.com.leroymarcel.store.controller.exception.NenhumProdutoEncontradoException;
import br.com.leroymarcel.store.controller.exception.ProdutoNaoEncontradoPeloIdException;
import br.com.leroymarcel.store.domain.entity.Produto;
import br.com.leroymarcel.store.repository.ProdutoRepository;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProdutoService {
    private ProdutoRepository repository;

    public Produto criarProduto(Produto produto) {
        return repository.save(produto);
    }

    @Transactional(rollbackOn = Exception.class)
    public Produto obterProduto(String id) {
        return repository.findById(id)
                .orElseThrow(ProdutoNaoEncontradoPeloIdException::new);
    }

    @Transactional(rollbackOn = Exception.class)
    public Page<Produto> obterTodosOsProdutos(Pageable pageable) {
        Page<Produto> produtos = repository.findAll(pageable);
        if (produtos.isEmpty()) throw new NenhumProdutoEncontradoException();

        ProdutoLoggerService.info("Produtos encontrados com sucesso!");

        return produtos;
    }

    @Transactional(rollbackOn = Exception.class)
    public Produto atualizarProduto(Produto produtoAtualizado, String id) {
        Produto produto = repository.findById(id)
                .orElseThrow(ProdutoNaoEncontradoPeloIdException::new);

        ProdutoLoggerService.info("Produto encontrado com sucesso!");

        produto.setNome(produtoAtualizado.getNome());
        produto.setQuantidade(produtoAtualizado.getQuantidade());
        produto.setPreco(produtoAtualizado.getPreco());

        ProdutoLoggerService.info("Produto atualizado com sucesso!");

        return produto;
    }

    @Transactional(rollbackOn = Exception.class)
    public void deletarProduto(String id) {
        repository.deleteById(id);
    }
}
