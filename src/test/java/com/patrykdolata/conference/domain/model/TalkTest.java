package com.patrykdolata.conference.domain.model;

import com.patrykdolata.conference.domain.exception.InvalidTalkLengthException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TalkTest {

    @Test
    void fromStringShouldReturnProperTalk() {
        // given
        var talk = "Writing Fast Tests Using Selenium 60min";
        var expected = new Talk(talk, 60);

        // when
        var result = Talk.fromString(talk);

        // then
        assertEquals(expected, result);
    }

    @Test
    void fromStringShouldReturnProperLightningTalk() {
        // given
        var talk = "Rails for Java Developers lightning";
        var expected = new Talk(talk, Talk.LIGHTNING_TALK_LENGTH);

        // when
        var result = Talk.fromString(talk);

        // then
        assertEquals(expected, result);
    }

    @Test
    void fromStringShouldThrowException() {
        // given
        var talk = "Rails for Java Developers 1h";

        // when then
        assertThrows(IllegalArgumentException.class, () -> Talk.fromString(talk));
    }

    @Test
    void fromStringShouldReturnProperTalkEvenIfThereIsNumberInTitle() {
        // given
        var talk = "What's new in Java 11 120min";
        var expected = new Talk(talk, 120);

        // when
        var result = Talk.fromString(talk);

        // then
        assertEquals(expected, result);
    }

    @Test
    void shouldThrowExceptionIfTalkLengthIsInvalid() {
        // given
        var talk = "Writing Fast Tests Using Selenium 250min";

        // when then
        assertThrows(InvalidTalkLengthException.class, () -> Talk.fromString(talk));
    }
}
