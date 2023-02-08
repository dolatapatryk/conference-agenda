package com.patrykdolata.conference.scheduler;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

class InputReaderTest {

    private final InputReader reader = new InputReader();

    @Test
    void shouldReadInputProperly() {
        // given
        var filename = "src/test/resources/talks.txt";
        var expected = List.of(
                new Talk("Writing Fast Tests Using Selenium 60min", 60),
                new Talk("Overdoing it in Java 45min", 45),
                new Talk("AngularJS for the Masses lightning", 5)
        );

        // when
        var result = reader.readInputFile(filename);

        // then
        assertIterableEquals(expected, result);
    }

    @Test
    void shouldReadEmptyInput() {
        // given
        var filename = "src/test/resources/empty-talks.txt";
        var expected = Collections.emptyList();

        // when
        var result = reader.readInputFile(filename);

        // then
        assertIterableEquals(expected, result);
    }
}
