package br.com.leroymarcel.store.service;

import br.com.leroymarcel.store.model.dto.AtualizarProdutoInputDTO;
import br.com.leroymarcel.store.model.dto.CadastroProdutoInputDTO;
import br.com.leroymarcel.store.model.dto.ProdutoOutputDTO;
import br.com.leroymarcel.store.model.entity.Produto;
import br.com.leroymarcel.store.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProdutoService {
    private ProdutoRepository repository;

    private ProdutoOutputDTO cadastrarProduto(CadastroProdutoInputDTO dto) {
        Produto produto = CadastroProdutoInputDTO.dtoParaEntidade(dto);
        produto = repository.save(produto);
        return ProdutoOutputDTO.entidadeParaDto(produto);
    }

    private ProdutoOutputDTO obterProduto(String id) {
        Produto produto = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));
        return ProdutoOutputDTO.entidadeParaDto(produto);
    }

    private List<ProdutoOutputDTO> obterTodosOsProdutos() {
        List<Produto> produtos = repository.findAll();
        if (produtos.isEmpty()) throw new RuntimeException("Nenhum produto encontrado!");

        return produtos.stream()
                .map(ProdutoOutputDTO::entidadeParaDto)
                .toList();
    }

    private ProdutoOutputDTO atualizarProduto(AtualizarProdutoInputDTO dto) {
        Produto produto = repository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("Produto não encontrado!"));

        produto.setNome(dto.getNome());
        produto.setMarca(dto.getMarca());
        produto.setQuantidade(dto.getQuantidade());
        produto.setPreco(dto.getPreco());

        produto = repository.save(produto);

        return ProdutoOutputDTO.entidadeParaDto(produto);
    }

    private void deletarProduto(String id) {
        repository.deleteById(id);
    }
}
