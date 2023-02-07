package com.patrykdolata.conference.domain;

public class ConferenceAgendaRunner {

    public void run(String[] args) {
        var inputReader = new InputReader();
        var talks = inputReader.readInputFile("sample.txt");
        System.out.println(talks.size());
        talks.forEach(System.out::println);
    }
}
