package org.cheesecake.xrage.exception.extended;

import org.springframework.http.HttpStatus;

public class UnauthorizedException extends AbstractException {
    public UnauthorizedException() {
        super(HttpStatus.UNAUTHORIZED);
    }
}
