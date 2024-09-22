package org.cheesecake.xrage.exception.extended;

import org.springframework.http.HttpStatus;

public class ValidationException extends AbstractException {

    public ValidationException(final String message) {
        super(message, HttpStatus.BAD_REQUEST);
    }
}
