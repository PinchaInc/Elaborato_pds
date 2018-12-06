package model

import junit.framework.TestCase.assertEquals
import org.junit.Test
import java.util.Date

class TestReview {

    @Test
    fun testSetMeeting() {
        val review = Review("title", "body")
        val group = Group("group")
        val meeting1 = Meeting(group, Date(), Date())
        review.meeting = meeting1
        assertEquals(meeting1, review.meeting)
        assertEquals(review, meeting1.review)
        val meeting2 = Meeting(group, Date(), Date())
        review.meeting = meeting2
        assertEquals(meeting1, review.meeting)
        assertEquals(review, meeting1.review)
    }
}