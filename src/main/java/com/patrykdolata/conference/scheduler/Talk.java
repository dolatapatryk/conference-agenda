package com.patrykdolata.conference.scheduler;

import java.util.regex.Pattern;

record Talk(String name, int length) {

    static final String LIGHTNING_TALK = "lightning";
    static final int LIGHTNING_TALK_LENGTH = 5;
    static final Pattern PATTERN = Pattern.compile(String.format("\\d+min|%s", LIGHTNING_TALK));

    static Talk fromString(String talk) {
        var matcher = PATTERN.matcher(talk);
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
