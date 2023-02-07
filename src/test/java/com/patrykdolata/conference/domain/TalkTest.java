package com.patrykdolata.conference.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TalkTest {

    @Test
    void fromStringShouldReturnProperTalk() {
        var talk = "Writing Fast Tests Using Selenium 60min";
        var expected = new Talk(talk, 60);
        var result = Talk.fromString(talk);
        assertEquals(expected, result);
    }

    @Test
    void fromStringShouldReturnProperLightningTalk() {
        var talk = "Rails for Java Developers lightning";
        var expected = new Talk(talk, Talk.LIGHTNING_TALK_LENGTH);
        var result = Talk.fromString(talk);
        assertEquals(expected, result);
    }
}
