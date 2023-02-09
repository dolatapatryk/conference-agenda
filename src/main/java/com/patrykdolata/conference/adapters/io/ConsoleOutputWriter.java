package com.patrykdolata.conference.adapters.io;

import com.patrykdolata.conference.ports.io.OutputWriter;
import com.patrykdolata.conference.domain.model.Conference;

public class ConsoleOutputWriter implements OutputWriter {

    public void writeOutput(Conference conference) {
        int i = 1;
        for (var track : conference.tracks()) {
            System.out.printf("Track %d:%n", i);
            for (var talk : track.events()) {
                System.out.println(talk);
            }
            i++;
        }
    }
}
