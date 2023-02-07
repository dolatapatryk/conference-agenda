package com.patrykdolata;

import com.patrykdolata.conference.domain.ConferenceAgendaRunner;
import com.patrykdolata.conference.domain.LPTConferenceScheduler;

public class Main {
    public static void main(String[] args) {
        var runner = new ConferenceAgendaRunner();
        runner.run(args, new LPTConferenceScheduler());
    }
}
