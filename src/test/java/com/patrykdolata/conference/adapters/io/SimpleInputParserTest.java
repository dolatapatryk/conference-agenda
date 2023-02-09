package com.patrykdolata.conference.adapters.io;

import com.patrykdolata.conference.domain.model.Talk;
import com.patrykdolata.conference.domain.exception.InvalidTalksNumberException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SimpleInputParserTest {

    private final SimpleInputParser parser = new SimpleInputParser();

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
