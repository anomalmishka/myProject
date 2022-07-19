package org.example.exception;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class ErrorTransaction extends RuntimeException {
    public ErrorTransaction(String textError) {
        super(textError);
        log.error(textError);
    }
}
