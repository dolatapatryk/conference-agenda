package com.patrykdolata.conference.scheduler;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
}
