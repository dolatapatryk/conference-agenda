package com.patrykdolata;

import com.patrykdolata.conference.domain.ConferenceAgendaRunner;

public class Main {
    public static void main(String[] args) {
        var runner = new ConferenceAgendaRunner();
        runner.run(args);
    }
}
