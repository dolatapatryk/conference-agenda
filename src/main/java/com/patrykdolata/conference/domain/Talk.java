package com.patrykdolata.conference.domain;

import java.util.regex.Pattern;

public record Talk(String name, int length) {

    static String LIGHTNING_TALK = "lightning";
    static int LIGHTNING_TALK_LENGTH = 5;
    static Pattern pattern = Pattern.compile(String.format("\\d+min|%s", LIGHTNING_TALK));

    static Talk fromString(String talk) {
        var matcher = pattern.matcher(talk);
        if (matcher.find()) {
            var talkLength = matcher.group();
            var length = talkLength.equals(LIGHTNING_TALK)
                    ? LIGHTNING_TALK_LENGTH
                    : Integer.parseInt(talkLength.replaceAll("min", ""));
            return new Talk(talk, length);
        }
        throw new IllegalArgumentException();
    }
}
