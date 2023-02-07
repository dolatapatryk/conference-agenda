package com.patrykdolata.conference.scheduler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

class InputReader {

    List<Talk> readInputFile(String filename) {
        try {
            var talks = new ArrayList<Talk>();
            var lines = Files.readAllLines(Path.of(filename));
            var count = Integer.parseInt(lines.get(0));
            for (int i = 1; i <= count; i++) {
                var line = lines.get(i);
                var talk = Talk.fromString(line);
                talks.add(talk);
            }
            return talks;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
