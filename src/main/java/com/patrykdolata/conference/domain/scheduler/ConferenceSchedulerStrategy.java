package com.patrykdolata.conference.domain.scheduler;

import com.patrykdolata.conference.domain.model.Conference;
import com.patrykdolata.conference.domain.model.Talk;

import java.util.List;

public interface ConferenceSchedulerStrategy {
    Conference scheduleConference(List<Talk> talks);
}
