package org.cheesecake.xrage.exception.extended;

import org.springframework.http.HttpStatus;

public class NotFoundUsernameException extends AbstractException {

    public NotFoundUsernameException() {
        super("Username not found", HttpStatus.NOT_FOUND);
    }
}
