package org.cheesecake.xrage.exception.handler;

import org.cheesecake.xrage.exception.extended.AbstractException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AbstractExceptionHandler {

    @ExceptionHandler(AbstractException.class)
    public ResponseEntity<String> abstractException(final AbstractException e) {
        return ResponseEntity.status(e.getStatus())
                .body(e.getMessage());
    }
}
