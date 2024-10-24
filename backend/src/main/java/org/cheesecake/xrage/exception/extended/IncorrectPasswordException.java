package org.cheesecake.xrage.exception.extended;

import org.springframework.http.HttpStatus;

public class IncorrectPasswordException extends AbstractException {
  
    public IncorrectPasswordException() {
        super("Incorrect password", HttpStatus.BAD_REQUEST);
    }
}
