package com.patrykdolata.conference.adapters;


import com.patrykdolata.conference.domain.scheduler.ConferenceSchedulerStrategy;
import com.patrykdolata.conference.domain.scheduler.LPTConferenceScheduler;
import com.patrykdolata.conference.ports.io.InputParser;
import com.patrykdolata.conference.ports.io.OutputWriter;

public class ConferenceAgendaRunner {

    private final InputParser inputParser;
    private final OutputWriter outputWriter;
    private ConferenceSchedulerStrategy strategy = new LPTConferenceScheduler();

    public ConferenceAgendaRunner(InputParser inputParser, OutputWriter outputWriter) {
        this.inputParser = inputParser;
        this.outputWriter = outputWriter;
    }

    public void run(String[] args) {
        var filename = args.length > 0 ? args[0] : "sample.txt";
        var talks = inputParser.parseInputFile(filename);
        var conference = strategy.scheduleConference(talks);
        outputWriter.writeOutput(conference);
    }

    public void setStrategy(ConferenceSchedulerStrategy strategy) {
        this.strategy = strategy;
    }
}
