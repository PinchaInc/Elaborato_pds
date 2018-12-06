package model

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import org.junit.Test

class TestWork {

    @Test
    fun testAddAndRemoveReview() {
        val group = Group("group")
        val workTrack = WorkTrack("title", "body")
        val review = Review("title", "body")
        val work = Work(group, workTrack)
        work.addReview(review)
        assertEquals(1, work.reviewsSize())
        assertEquals(work, review.work)
        work.addReview(review)
        assertEquals(1, work.reviewsSize())
        work.removeReview(review)
        assertEquals(0, work.reviewsSize())
        assertNull(review.work)
    }

    @Test
    fun testCreateWork() {
        val group = Group("group")
        val workTrack = WorkTrack("title", "body")
        val work = Work.createWork(group, workTrack)
        assertNotNull(work)
    }

    @Test
    fun testCreateWorkErrorBusyGroup() {
        val group = Group("group")
        val workTrack1 = WorkTrack("title1", "body1")
        val workTrack2 = WorkTrack("title2", "body2")
        val work1 = Work.createWork(group, workTrack1)
        val work2 = Work.createWork(group, workTrack2)
        assertNull(work2)
        assertEquals(work1, group.work)
    }
}