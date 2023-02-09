package com.patrykdolata.conference.domain.scheduler;

import com.patrykdolata.conference.domain.model.Event;
import com.patrykdolata.conference.domain.model.Talk;
import org.junit.jupiter.api.Test;

import java.time.LocalTime;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LPTConferenceSchedulerTest {

    private final LPTConferenceScheduler scheduler = new LPTConferenceScheduler();


    @Test
    void shouldProperScheduleConference() {
        // given
        var talks = List.of(
                new Talk("TalkOne 90min", 90),
                new Talk("TalkTwo 90min", 90),
                new Talk("TalkThree 90min", 90),
                new Talk("TalkFour 90min", 90),
                new Talk("TalkFive 90min", 90),
                new Talk("TalkSix 181min", 181),
                new Talk("TalkSeven 90min", 90),
                new Talk("TalkEight 90min", 90),
                new Talk("TalkNine lightning", 5),
                new Talk("TalkTen 60min", 60)
        );
        var expectedFirstTrack = List.of(
                new Event(LocalTime.of(9, 0), "TalkOne 90min", 90),
                new Event(LocalTime.of(10, 30), "TalkTwo 90min", 90),
                new Event(LocalTime.of(12, 0), Event.LUNCH_EVENT, Event.LUNCH_LENGTH),
                new Event(LocalTime.of(13, 0), "TalkSix 181min", 181),
                new Event(LocalTime.of(16, 1), "TalkNine lightning", 5),
                new Event(LocalTime.of(16, 6), Event.SNACKS_EVENT, 0)
        );
        var expectedSecondTrack = List.of(
                new Event(LocalTime.of(9, 0), "TalkThree 90min", 90),
                new Event(LocalTime.of(10, 30), "TalkFour 90min", 90),
                new Event(LocalTime.of(12, 0), Event.LUNCH_EVENT, Event.LUNCH_LENGTH),
                new Event(LocalTime.of(13, 0), "TalkFive 90min", 90),
                new Event(LocalTime.of(14, 30), "TalkSeven 90min", 90),
                new Event(LocalTime.of(16, 0), "TalkTen 60min", 60),
                new Event(LocalTime.of(17, 0), Event.SNACKS_EVENT, 0)
        );
        var expectedThirdTrack = List.of(
                new Event(LocalTime.of(9, 0), "TalkEight 90min", 90),
                new Event(LocalTime.of(12, 0), Event.LUNCH_EVENT, Event.LUNCH_LENGTH),
                new Event(LocalTime.of(13, 0), Event.SNACKS_EVENT, 0)
        );

        // when
        var result = scheduler.scheduleConference(talks);

        // then
        assertEquals(3, result.tracks().size());
        assertIterableEquals(expectedFirstTrack, result.tracks().get(0).events());
        assertIterableEquals(expectedSecondTrack, result.tracks().get(1).events());
        assertIterableEquals(expectedThirdTrack, result.tracks().get(2).events());
    }

    @Test
    void shouldReturnEmptyConference() {
        // given
        List<Talk> talks = Collections.emptyList();

        // when
        var result = scheduler.scheduleConference(talks);

        // then
        assertTrue(result.tracks().isEmpty());
    }
}
