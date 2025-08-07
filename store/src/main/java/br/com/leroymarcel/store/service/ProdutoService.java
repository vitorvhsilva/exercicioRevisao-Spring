package br.com.leroymarcel.store.service;

import br.com.leroymarcel.store.domain.dto.ProdutoOutputDTO;
import br.com.leroymarcel.store.domain.entity.Produto;
import br.com.leroymarcel.store.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {
    private ProdutoRepository repository;

    public Produto criarProduto(Produto produto) {
        return repository.save(produto);
    }

    public Produto obterProduto(String id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
    }

    public Page<Produto> obterTodosOsProdutos(Pageable pageable) {
        Page<Produto> produtos = repository.findAll(pageable);
        if (produtos.isEmpty()) throw new RuntimeException("Nenhum produto encontrado!");

        return produtos;
    }

    public Produto atualizarProduto(Produto produtoAtualizado, String id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

        produto.setNome(produtoAtualizado.getNome());
        produto.setQuantidade(produtoAtualizado.getQuantidade());
        produto.setPreco(produtoAtualizado.getPreco());

        return repository.save(produto);
    }

    public void deletarProduto(String id) {
        repository.deleteById(id);
    }
}
