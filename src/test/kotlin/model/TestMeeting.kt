package model

import junit.framework.TestCase.assertEquals
import org.junit.Test
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
}