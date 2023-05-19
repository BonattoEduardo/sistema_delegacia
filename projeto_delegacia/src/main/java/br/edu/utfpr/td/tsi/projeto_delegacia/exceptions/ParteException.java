package br.edu.utfpr.td.tsi.projeto_delegacia.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class ParteException extends RuntimeException {

    public ParteException() {
        super("Parte não informada.");
    }
}
