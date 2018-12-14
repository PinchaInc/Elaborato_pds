package model

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import org.junit.Test
import java.text.SimpleDateFormat
import java.util.Date

class TestMeeting {

    @Test
    fun testSetReview() {
        val group = Group("group")
        val meeting = Meeting(group, Date(), Date())
        val review1 = Review("title1", "body1")
        meeting.review = review1
        assertEquals(review1, meeting.review)
        assertEquals(meeting, review1.meeting)
    }

    @Test
    fun testMakeMeeting() {
        val group = Group("group")
        val sdf = SimpleDateFormat("dd-MM-yyyy")
        val start = sdf.parse("25-12-2019")
        val meeting = Meeting.makeMeeting(group, start)
        assertNotNull(meeting)
    }

    @Test
    fun testMakeMeetingError() {
        val group = Group("group")
        val sdf = SimpleDateFormat("dd-MM-yyyy")
        val start = sdf.parse("05-12-2018")
        val meeting = Meeting.makeMeeting(group, start)
        assertNull(meeting)
    }
}