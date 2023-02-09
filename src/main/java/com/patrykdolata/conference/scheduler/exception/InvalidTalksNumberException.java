package com.patrykdolata.conference.scheduler.exception;

public class InvalidTalksNumberException extends RuntimeException {

    public InvalidTalksNumberException(int min, int max) {
        super(String.format("Invalid number of defined Talks. Number should be: %d <= N <= %d", min, max));
    }
}
