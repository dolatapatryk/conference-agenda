package com.patrykdolata;

import com.patrykdolata.conference.scheduler.ConferenceAgendaRunner;
import com.patrykdolata.conference.scheduler.LPTConferenceScheduler;

public class Main {
    public static void main(String[] args) {
        var runner = new ConferenceAgendaRunner();
        runner.setStrategy(new LPTConferenceScheduler());
        runner.run(args);
    }
}
