package br.com.itau.api.exception;

import lombok.Getter;

public class ObjectNotFoundException extends RuntimeException{

    @Getter
    private Object[] params;

    public ObjectNotFoundException(String message) {
        super(message);
        this.params = new Object[]{};
    }
}
