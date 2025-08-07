package br.com.leroymarcel.store.controller.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Arrays;

@Data
public class ExceptionDTO {
    private String codigo;
    private String mensagem;
    private String stackTrace;
    private LocalDateTime dataHoraException = LocalDateTime.now();

    public ExceptionDTO(
        HttpStatus statusCode,
        Exception e
    ) {
        this.codigo = statusCode.name();
        this.mensagem = e.getMessage();
        this.stackTrace = Arrays.toString(e.getStackTrace());
    }

    public ExceptionDTO(
            HttpStatus statusCode,
            Exception e,
            String mensagem
    ) {
        this.codigo = statusCode.name();
        this.mensagem = mensagem;
        this.stackTrace = Arrays.toString(e.getStackTrace());
    }
}
