package br.com.leroymarcel.store.controller.exception;

public class NenhumProdutoEncontradoException extends RuntimeException{
    public NenhumProdutoEncontradoException() {
        super("Nenhum produto encontrado com esse id!");
    }
}
