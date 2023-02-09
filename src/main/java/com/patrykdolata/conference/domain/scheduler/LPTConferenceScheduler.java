package com.patrykdolata.conference.domain.scheduler;

import com.patrykdolata.conference.domain.model.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Longest-processing-time-first (LPT) algorithm implementation of conference scheduler.
 * <p>
 * The algorithm work as follows:
 * <p>
 * 1. Order the Talks by descending order of their length, such that the longest Talk is first
 * <p>
 * 2. Schedule Talk in this sequence into a Track
 * <p>
 * Tracks are added as needed
 * <p>
 * For more information check: <a href="https://en.wikipedia.org/wiki/Longest-processing-time-first_scheduling">Longest-processing-time-first scheduling</a>
 */
public class LPTConferenceScheduler implements ConferenceSchedulerStrategy {

    @Override
    public Conference scheduleConference(List<Talk> talks) {
        // copy in case of immutable input list
        talks = new ArrayList<>(talks);
        // sort by length descending
        talks.sort((o1, o2) -> o2.length() - o1.length());
        var tracks = new ArrayList<Track>();
        while (!talks.isEmpty()) {
            tracks.add(scheduleTrack(talks));
        }
        return new Conference(tracks);
    }

    private Track scheduleTrack(List<Talk> talks) {
        // schedule morning session
        var morningSession = Session.MORNING;
        var morningEvents = scheduleSessionEvents(morningSession, talks);
        morningEvents.add(new Event(morningSession.getEnd(), Event.LUNCH_EVENT, Event.LUNCH_LENGTH));
        var trackEvents = new ArrayList<>(morningEvents);

        // schedule afternoon session
        var afternoonEvents = scheduleSessionEvents(Session.AFTERNOON, talks);
        trackEvents.addAll(afternoonEvents);
        var lastEvent = trackEvents.get(trackEvents.size() - 1);
        trackEvents.add(new Event(lastEvent.getEnd(), Event.SNACKS_EVENT, 0));

        return new Track(trackEvents);
    }

    private List<Event> scheduleSessionEvents(Session session, List<Talk> talks) {
        var events = new ArrayList<Event>();
        var actualTime = session.getStart();
        var sessionEnd = session.getEnd();
        var iterator = talks.listIterator();
        while (iterator.hasNext()) {
            var talk = iterator.next();
            var talkEndTime = actualTime.plusMinutes(talk.length());
            if (talkEndTime.isBefore(sessionEnd) || talkEndTime.equals(sessionEnd)) {
                var event = new Event(actualTime, talk.name(), talk.length());
                events.add(event);
                iterator.remove();
                actualTime = talkEndTime;
            }
        }
        return events;
    }
}
