package br.com.leroymarcel.store.service;

import br.com.leroymarcel.store.model.dto.CadastroProdutoInputDTO;
import br.com.leroymarcel.store.model.dto.CadastroProdutoOutputDTO;
import br.com.leroymarcel.store.model.entity.Produto;
import br.com.leroymarcel.store.repository.ProdutoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProdutoService {
    private ProdutoRepository repository;

    private CadastroProdutoOutputDTO cadastrarProduto(CadastroProdutoInputDTO dto) {
        Produto produto = CadastroProdutoInputDTO.dtoParaEntidade(dto);
        produto = repository.save(produto);
        return CadastroProdutoOutputDTO.entidadeParaDto(produto);
    }
}
