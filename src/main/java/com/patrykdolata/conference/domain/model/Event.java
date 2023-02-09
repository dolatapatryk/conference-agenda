package com.patrykdolata.conference.domain.model;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public record Event(LocalTime start, String name, int length) {

    public static final String LUNCH_EVENT = "Lunch";
    public static final int LUNCH_LENGTH = 60;
    public static final String SNACKS_EVENT = "Snacks";
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("hh:mma");


    public LocalTime getEnd() {
        return start.plusMinutes(length);
    }

    @Override
    public String toString() {
        var time = start.format(FORMATTER);
        return String.format("%s %s", time, name);
    }
}
