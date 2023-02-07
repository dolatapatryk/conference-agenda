package com.patrykdolata.conference.scheduler;

import java.util.List;

public interface ConferenceSchedulerStrategy {
    Conference scheduleConference(List<Talk> talks);
}
