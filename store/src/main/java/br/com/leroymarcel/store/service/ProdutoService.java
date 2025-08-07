package br.com.leroymarcel.store.service;

import br.com.leroymarcel.store.domain.dto.AtualizarProdutoInputDTO;
import br.com.leroymarcel.store.domain.dto.CadastroProdutoInputDTO;
import br.com.leroymarcel.store.domain.dto.ProdutoOutputDTO;
import br.com.leroymarcel.store.domain.entity.Produto;
import br.com.leroymarcel.store.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProdutoService {
    private ProdutoRepository repository;

    public ProdutoOutputDTO criarProduto(Produto produto) {
        produto = repository.save(produto);
        return ProdutoOutputDTO.entidadeParaDto(produto);
    }

    public ProdutoOutputDTO obterProduto(String id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
        return ProdutoOutputDTO.entidadeParaDto(produto);
    }

    public List<ProdutoOutputDTO> obterTodosOsProdutos() {
        List<Produto> produtos = repository.findAll();
        if (produtos.isEmpty()) throw new RuntimeException("Nenhum produto encontrado!");

        return produtos.stream()
                .map(ProdutoOutputDTO::entidadeParaDto)
                .toList();
    }

    public ProdutoOutputDTO atualizarProduto(Produto produtoAtualizado, String id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

        produto.setNome(produtoAtualizado.getNome());
        produto.setQuantidade(produtoAtualizado.getQuantidade());
        produto.setPreco(produtoAtualizado.getPreco());

        produto = repository.save(produto);

        return ProdutoOutputDTO.entidadeParaDto(produto);
    }

    public void deletarProduto(String id) {
        repository.deleteById(id);
    }
}
