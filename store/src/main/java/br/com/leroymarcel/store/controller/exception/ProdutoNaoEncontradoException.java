package br.com.leroymarcel.store.controller.exception;

public class ProdutoNaoEncontradoException extends RuntimeException{
    public ProdutoNaoEncontradoException() {
        super("Nenhum produto encontrado com esse id!");
    }
}
