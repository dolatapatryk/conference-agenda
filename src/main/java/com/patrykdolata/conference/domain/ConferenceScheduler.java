package com.patrykdolata.conference.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

public abstract class ConferenceScheduler {
    public Conference scheduleConference(List<Talk> talks) {
        var tracksCount = calculateNumberOfNeededTracks(talks);
        return scheduleConference(talks, tracksCount);
    }

    public abstract Conference scheduleConference(List<Talk> talks, int tracksCount);

    private int calculateNumberOfNeededTracks(List<Talk> talks) {
        var total = talks.stream()
                .map(Talk::length)
                .reduce(0, Integer::sum);
        var totalTime = BigDecimal.valueOf(total);
        var totalSessionsLength = BigDecimal.ZERO;
        for (var session : Session.values()) {
            var sessionLength = session.length();
            totalSessionsLength = totalSessionsLength.add(BigDecimal.valueOf(sessionLength));
        }
        return totalTime.divide(totalSessionsLength, RoundingMode.CEILING).intValue();
    }
}
