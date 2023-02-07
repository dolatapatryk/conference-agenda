package com.patrykdolata.conference.scheduler;

import lombok.Getter;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

@Getter
public enum Session {
    MORNING(LocalTime.of(9, 0), LocalTime.of(12, 0)),
    AFTERNOON(LocalTime.of(13, 0), LocalTime.of(17, 0));

    private final LocalTime start;
    private final LocalTime end;

    Session(LocalTime start, LocalTime end) {
        this.start = start;
        this.end = end;
    }

    long length() {
        return ChronoUnit.MINUTES.between(start, end);
    }
}
