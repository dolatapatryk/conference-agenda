package com.patrykdolata.conference.scheduler;

public class ConferenceAgendaRunner {

    private ConferenceSchedulerStrategy strategy = new LPTConferenceScheduler();

    public void run(String[] args) {
        var filename = args.length > 0 ? args[0] : "sample.txt";
        var inputReader = new InputReader();
        var talks = inputReader.readInputFile(filename);
        var conference = strategy.scheduleConference(talks);
        var outputWriter = new OutputWriter();
        outputWriter.writeOutput(conference);
    }

    public void setStrategy(ConferenceSchedulerStrategy strategy) {
        this.strategy = strategy;
    }
}
