package com.patrykdolata.conference.domain;

public class ConferenceAgendaRunner {

    public void run(String[] args, ConferenceScheduler scheduler) {
        var filename = args.length > 0 ? args[0] : "sample.txt";
        var inputReader = new InputReader();
        var talks = inputReader.readInputFile(filename);
        var conference = scheduler.scheduleConference(talks);
        var outputWriter = new OutputWriter();
        outputWriter.writeOutputFile(conference);
    }
}
