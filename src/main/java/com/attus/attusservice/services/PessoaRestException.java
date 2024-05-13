package com.attus.attusservice.services;

import com.attus.attusservice.models.ErrosExcecao;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class PessoaRestException {

    @ExceptionHandler(PessoaException.class)
    public ResponseEntity<ErrosExcecao> genericException(Exception ex) {
       return ResponseEntity.status(400).body(new ErrosExcecao(LocalDateTime.now(),400,ex.getMessage()));
    }
}
