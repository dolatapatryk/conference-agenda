package com.patrykdolata.conference.scheduler;

class OutputWriter {

    void writeOutput(Conference conference) {
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
