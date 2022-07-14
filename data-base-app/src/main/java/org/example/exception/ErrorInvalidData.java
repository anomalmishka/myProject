package org.example.exception;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ErrorInvalidData extends RuntimeException {
    public ErrorInvalidData(String textError) {
        super(textError);
        log.error(textError);
    }
}
