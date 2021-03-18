package br.com.itau.api.handle.helper;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class StandardError implements Serializable {

    private static final long serialVersionUID = -7257803475934561466L;

    private Long timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;
    private String exception;
}
