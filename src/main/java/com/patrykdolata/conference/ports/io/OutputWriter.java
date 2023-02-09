package com.patrykdolata.conference.ports.io;

import com.patrykdolata.conference.domain.model.Conference;

public interface OutputWriter {

    void writeOutput(Conference conference);
}
