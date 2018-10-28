package model

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.util.Date

class TestAgenda {

    @Test
    fun testAddAndRemoveMeeting() {
        val tutor = Tutor(
            "name",
            "surname",
            Date(),
            "email",
            1
        )
        val agenda = Agenda(tutor)

        val meeting = Meeting(
            Group("group"),
            Date(),
            Date()
        )

        agenda.addMeeting(meeting)
        assertEquals(1, agenda.meetings.size)
        agenda.addMeeting(meeting)
        assertEquals(1, agenda.meetings.size)
        agenda.removeMeeting(meeting)
        assertEquals(0, agenda.meetings.size)
    }
}