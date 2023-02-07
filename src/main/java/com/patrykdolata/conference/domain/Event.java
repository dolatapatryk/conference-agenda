package com.patrykdolata.conference.domain;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public record Event(LocalTime start, String name, int length) {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("hh:mma");


    LocalTime getEnd() {
        return start.plusMinutes(length);
    }

    @Override
    public String toString() {
        var time = start.format(FORMATTER);
        return String.format("%s %s", time, name);
    }
}
