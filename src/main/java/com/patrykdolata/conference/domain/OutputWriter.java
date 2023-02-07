package com.patrykdolata.conference.domain;

public class OutputWriter {

    void writeOutputFile(Conference conference) {
        int i = 1;
        for (var track : conference.tracks()) {
            System.out.printf("Track %d:%n", i);
            for (var talk : track.events()) {
                System.out.println(talk.toString());
            }
            i++;
        }
    }
}
