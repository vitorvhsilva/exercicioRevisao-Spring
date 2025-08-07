package br.com.leroymarcel.store.controller.exception;

import br.com.leroymarcel.store.service.ProdutoLoggerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.stream.Collectors;


@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ProdutoNaoEncontradoException.class)
    public ResponseEntity<ExceptionDTO> handleProdutoNaoEncontrado(ProdutoNaoEncontradoException ex) {
        ProdutoLoggerService.erro("Ocorreu o seguinte erro ao criar um produto: " + ex.getMessage(), ex);

        ExceptionDTO exceptionDTO = new ExceptionDTO(HttpStatus.NOT_FOUND, ex);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionDTO);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionDTO> handleValidacaoInvalida(MethodArgumentNotValidException ex) {
        String mensagem = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(error -> error.getField() + ": " + error.getDefaultMessage())
                .collect(Collectors.joining("; "));

        ProdutoLoggerService.erro("Ocorreu o seguinte erro ao validar o dto de entrada: " + mensagem, ex);

        ExceptionDTO dto = new ExceptionDTO(HttpStatus.UNPROCESSABLE_ENTITY, ex, mensagem);
        return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(dto);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionDTO> handleRuntime(RuntimeException ex) {
        ProdutoLoggerService.erro("Ocorreu o seguinte erro ao criar um produto: " + ex.getMessage(), ex);

        ExceptionDTO exceptionDTO = new ExceptionDTO(HttpStatus.BAD_REQUEST, ex);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ExceptionDTO> handleGeral(Exception ex) {
        ProdutoLoggerService.erro("Ocorreu o seguinte erro ao criar um produto: " + ex.getMessage(), ex);

        ExceptionDTO exceptionDTO = new ExceptionDTO(HttpStatus.BAD_REQUEST, new RuntimeException("Exceção inesperada"));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionDTO);
    }
}
