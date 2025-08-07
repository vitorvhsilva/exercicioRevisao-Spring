package br.com.leroymarcel.store.service;

import br.com.leroymarcel.store.domain.entity.Produto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProdutoLoggerService {
    public static void info(String info){
        log.info(info);
    }

    public static void erro(String erro, Exception exception){
        log.error(erro, exception);
    }

    public static void sucesso(String sucesso, Produto produto){
        log.info(sucesso, produto);
    }
}
