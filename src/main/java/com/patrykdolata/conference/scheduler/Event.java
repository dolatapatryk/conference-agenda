package com.patrykdolata.conference.scheduler;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

record Event(LocalTime start, String name, int length) {

    static final String LUNCH_EVENT = "Lunch";
    static final int LUNCH_LENGTH = 60;
    static final String SNACKS_EVENT = "Snacks";
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
