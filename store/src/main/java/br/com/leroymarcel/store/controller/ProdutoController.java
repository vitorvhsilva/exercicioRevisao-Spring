package br.com.leroymarcel.store.controller;

import br.com.leroymarcel.store.domain.dto.AtualizarProdutoInputDTO;
import br.com.leroymarcel.store.domain.dto.CadastroProdutoInputDTO;
import br.com.leroymarcel.store.domain.dto.ProdutoOutputDTO;
import br.com.leroymarcel.store.domain.entity.Produto;
import br.com.leroymarcel.store.service.ProdutoLoggerService;
import br.com.leroymarcel.store.service.ProdutoService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("produtos")
@AllArgsConstructor
public class ProdutoController {
    private ProdutoService produtoService;

    @PostMapping
    public ResponseEntity<ProdutoOutputDTO> criarProduto(@RequestBody @Valid CadastroProdutoInputDTO inputDTO) {
        Produto produto = CadastroProdutoInputDTO.dtoParaEntidade(inputDTO);
        Produto produtoCriado = produtoService.criarProduto(produto);
        ProdutoOutputDTO outputDTO = ProdutoOutputDTO.entidadeParaDto(produtoCriado);
        ProdutoLoggerService.sucesso("Produto criado com sucesso!");
        return ResponseEntity.status(HttpStatus.CREATED).body(outputDTO);
    }

    @GetMapping
    public Page<ProdutoOutputDTO> obterTodosOsProdutos(
        @RequestParam(defaultValue = "1", required = false) Integer pagina,
        @RequestParam(defaultValue = "5", required = false) Integer tamanho
    ){
        Pageable pageable = PageRequest.of(pagina, tamanho);
        Page<ProdutoOutputDTO> outputsDTO = ProdutoOutputDTO.entidadeParaDto(produtoService.obterTodosOsProdutos(pageable));
        ProdutoLoggerService.sucesso("Produtos retornados com sucesso!");
        return outputsDTO;
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProdutoOutputDTO> obterProduto(@PathVariable String id) {
        Produto produto = produtoService.obterProduto(id);
        ProdutoOutputDTO outputDTO = ProdutoOutputDTO.entidadeParaDto(produto);
        ProdutoLoggerService.sucesso("Produtos obtido com sucesso!");
        return ResponseEntity.status(HttpStatus.OK).body(outputDTO);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ProdutoOutputDTO> atualizarProduto(
        @PathVariable String id,
        @RequestBody AtualizarProdutoInputDTO inputDTO
    ) {
        Produto produto = AtualizarProdutoInputDTO.dtoParaEntidade(inputDTO);
        produto = produtoService.atualizarProduto(produto, id);
        ProdutoOutputDTO outputDTO = ProdutoOutputDTO.entidadeParaDto(produto);
        ProdutoLoggerService.sucesso("Produtos atualizado com sucesso!");
        return ResponseEntity.status(HttpStatus.OK).body(outputDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable String id) {
        produtoService.deletarProduto(id);
        ProdutoLoggerService.sucesso("Produtos excluido com sucesso!");
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
