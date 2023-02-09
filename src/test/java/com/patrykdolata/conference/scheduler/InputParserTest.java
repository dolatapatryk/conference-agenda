package com.patrykdolata.conference.scheduler;

import com.patrykdolata.conference.scheduler.exception.InvalidTalksNumberException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InputParserTest {

    private final InputParser parser = new InputParser();

    @Test
    void shouldParseInputProperly() {
        // given
        var filename = "src/test/resources/talks.txt";
        var expected = List.of(
                new Talk("Writing Fast Tests Using Selenium 60min", 60),
                new Talk("Overdoing it in Java 45min", 45),
                new Talk("AngularJS for the Masses lightning", 5)
        );

        // when
        var result = parser.parseInputFile(filename);

        // then
        assertIterableEquals(expected, result);
    }

    @Test
    void shouldThrowIfInputIsEmpty() {
        // given
        var filename = "src/test/resources/empty-talks.txt";

        // when then
        assertThrows(InvalidTalksNumberException.class, () -> parser.parseInputFile(filename));
    }

    @Test
    void shouldThrowIfInputIsOutOfBound() {
        // given
        var filename = "src/test/resources/too-many-talks.txt";

        // when then
        assertThrows(InvalidTalksNumberException.class, () -> parser.parseInputFile(filename));
    }
}
