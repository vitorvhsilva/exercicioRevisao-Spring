package br.com.leroymarcel.store.controller;

import br.com.leroymarcel.store.domain.dto.CadastroProdutoInputDTO;
import br.com.leroymarcel.store.domain.dto.ProdutoOutputDTO;
import br.com.leroymarcel.store.domain.entity.Produto;
import br.com.leroymarcel.store.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController("produtos")
@AllArgsConstructor
public class ProdutoController {
    private ProdutoService produtoService;

    public ResponseEntity<ProdutoOutputDTO> criarProduto(@RequestBody @Valid CadastroProdutoInputDTO inputDTO) {
        Produto produto = CadastroProdutoInputDTO.dtoParaEntidade(inputDTO);
        ProdutoOutputDTO outputDTO = produtoService.criarProduto(produto);
        return ResponseEntity.status(HttpStatus.CREATED).body(outputDTO);
    }
}
