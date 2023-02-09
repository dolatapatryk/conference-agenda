package com.patrykdolata;

import com.patrykdolata.conference.adapters.ConferenceAgendaRunner;
import com.patrykdolata.conference.adapters.io.ConsoleOutputWriter;
import com.patrykdolata.conference.adapters.io.SimpleInputParser;
import com.patrykdolata.conference.domain.scheduler.LPTConferenceScheduler;

public class ConferenceApplication {
    public static void main(String[] args) {
        var runner = new ConferenceAgendaRunner(new SimpleInputParser(), new ConsoleOutputWriter());
        runner.setStrategy(new LPTConferenceScheduler());
        runner.run(args);
    }
}
