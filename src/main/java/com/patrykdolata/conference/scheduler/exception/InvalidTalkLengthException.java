package com.patrykdolata.conference.scheduler.exception;

public class InvalidTalkLengthException extends RuntimeException {

    public InvalidTalkLengthException(int max) {
        super(String.format("Talk's length is invalid. Length should be <= %d", max));
    }
}
