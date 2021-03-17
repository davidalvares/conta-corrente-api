package br.com.itau.api.exception;

import org.springframework.http.HttpStatus;

public class NegocioException extends RuntimeException{

    private String message;
    private HttpStatus status;

    public NegocioException(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
