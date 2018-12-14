package model

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
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

    @Test
    fun testMakeFinalReview() {
        val finalReview = FinalReview.makeFinalReview("title", "body", 30)
        assertNotNull(finalReview)
    }

    @Test
    fun testMakeFinalReviewError() {
        val finalReview = FinalReview.makeFinalReview("title", "body", 31)
        assertNull(finalReview)
    }
}