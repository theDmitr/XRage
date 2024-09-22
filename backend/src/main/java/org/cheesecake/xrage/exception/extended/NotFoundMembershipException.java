package org.cheesecake.xrage.exception.extended;

import org.springframework.http.HttpStatus;

public class NotFoundMembershipException extends AbstractException {

    public NotFoundMembershipException() {
        super("Membership not found!", HttpStatus.NOT_FOUND);
    }
}
