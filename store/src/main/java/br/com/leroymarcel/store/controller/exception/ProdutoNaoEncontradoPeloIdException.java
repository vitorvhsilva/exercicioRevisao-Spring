package br.com.leroymarcel.store.controller.exception;

public class ProdutoNaoEncontradoPeloIdException extends RuntimeException{
    public ProdutoNaoEncontradoPeloIdException() {
        super("Nenhum produto encontrado com esse id!");
    }
}
