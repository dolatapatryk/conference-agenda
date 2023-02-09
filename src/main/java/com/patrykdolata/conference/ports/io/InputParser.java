package com.patrykdolata.conference.ports.io;

import com.patrykdolata.conference.domain.model.Talk;

import java.util.List;

public interface InputParser {

    List<Talk> parseInputFile(String filename);
}
