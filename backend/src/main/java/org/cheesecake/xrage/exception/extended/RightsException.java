package org.cheesecake.xrage.exception.extended;

import org.springframework.http.HttpStatus;

public class RightsException extends AbstractException {

    public RightsException() {
        super(HttpStatus.FORBIDDEN);
    }
}
