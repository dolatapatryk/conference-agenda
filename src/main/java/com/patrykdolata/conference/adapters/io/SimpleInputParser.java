package com.patrykdolata.conference.adapters.io;

import com.patrykdolata.conference.ports.io.InputParser;
import com.patrykdolata.conference.domain.model.Talk;
import com.patrykdolata.conference.domain.exception.InvalidTalksNumberException;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class SimpleInputParser implements InputParser {

    private static final int MIN_TALKS_NUMBER = 1;
    private static final int MAX_TALKS_NUMBER = 20;

    public List<Talk> parseInputFile(String filename) {
        try {
            var talks = new ArrayList<Talk>();
            var lines = Files.readAllLines(Path.of(filename));
            var count = Integer.parseInt(lines.get(0));
            validateTalksNumber(count);
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

    private void validateTalksNumber(int count) {
        if (count < MIN_TALKS_NUMBER || count > MAX_TALKS_NUMBER) {
            throw new InvalidTalksNumberException(MIN_TALKS_NUMBER, MAX_TALKS_NUMBER);
        }
    }
}
