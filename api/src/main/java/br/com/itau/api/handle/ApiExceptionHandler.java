package br.com.itau.api.handle;

import br.com.itau.api.exception.ObjectNotFoundException;
import br.com.itau.api.handle.helper.StandardError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

import static org.springframework.http.HttpStatus.NOT_FOUND;


@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    private final MessageSource messageSource;

    @Autowired
    public ApiExceptionHandler(MessageSource messageSource) {
        this.messageSource = messageSource;
    }
    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
        String message = messageSource.getMessage(e.getMessage(),e.getParams(), request.getLocale());
        StandardError error = new StandardError(System.currentTimeMillis(), NOT_FOUND.value(),"Não encontrado",
                message,request.getRequestURI(),e.getClass().getName());
        return ResponseEntity.status(NOT_FOUND).body(error);
    }
}
