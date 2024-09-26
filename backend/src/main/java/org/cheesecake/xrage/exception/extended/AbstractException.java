package org.cheesecake.xrage.exception.extended;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class AbstractException extends RuntimeException {

    private final HttpStatus status;

    public AbstractException(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }

    public AbstractException(HttpStatus status) {
        this(null, status);
    }
}
