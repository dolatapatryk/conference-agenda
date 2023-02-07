package com.patrykdolata.conference.domain;

import java.util.ArrayList;
import java.util.List;

public class LPTConferenceScheduler extends ConferenceScheduler {

    @Override
    public Conference scheduleConference(List<Talk> talks, int tracksCount) {
        talks.sort((o1, o2) -> o2.length() - o1.length());
        var tracks = new ArrayList<Track>(tracksCount);
        for (int i = 0; i < tracksCount; i++) {
            tracks.add(scheduleTrack(talks));
        }
        return new Conference(tracks);
    }

    private Track scheduleTrack(List<Talk> talks) {
//        for (var session : Session.values()) {
//            var sessionEvents = scheduleSessionEvents(session, talks);
//
//        }
        var morningSession = Session.MORNING;
        var morningJobs = scheduleSessionEvents(morningSession, talks);
        morningJobs.add(new Event(morningSession.getEnd(), "Lunch", 60));
        var trackEvents = new ArrayList<>(morningJobs);

        var afternoonSession = Session.AFTERNOON;
        var afternoonJobs = scheduleSessionEvents(afternoonSession, talks);
        var lastEvent = afternoonJobs.get(afternoonJobs.size() - 1);
        afternoonJobs.add(new Event(lastEvent.getEnd(), "Networking Event", 0));
        trackEvents.addAll(afternoonJobs);

        return new Track(trackEvents);
    }

    private List<Event> scheduleSessionEvents(Session session, List<Talk> talks) {
        var events = new ArrayList<Event>();
        var actualTime = session.getStart();
        var sessionEnd = session.getEnd();
        var iterator = talks.listIterator();
        while (iterator.hasNext()) {
            var talk = iterator.next();
            var newTime = actualTime.plusMinutes(talk.length());
            if (newTime.isBefore(sessionEnd) || newTime.equals(sessionEnd)) {
                var job = new Event(actualTime, talk.name(), talk.length());
                events.add(job);
                iterator.remove();
                actualTime = newTime;
            }
        }
        return events;
    }
}
