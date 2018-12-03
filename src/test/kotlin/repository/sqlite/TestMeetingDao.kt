package repository.sqlite

import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import org.junit.Test
import repository.MeetingHelper
import java.util.Date

class TestMeetingDao {
    val dao = MeetingDao(DaoFactory())

    @Test
    fun testCreate() {
        val meeting = MeetingHelper(Date(), Date(), 0, null, 101, "group1")
        assertTrue(dao.create(meeting))
    }

    @Test
    fun testRead() {
        val meeting = dao.read(Pair("group1", 0))
        assertNotNull(meeting)
        assertNotNull(meeting!!.review)
    }

    @Test
    fun testReadNullReviw() {
        val meeting = dao.read(Pair("group1", 1))
        assertNotNull(meeting)
        assertNull(meeting!!.review)
    }

    @Test
    fun testUpdate() {
        val meeting = MeetingHelper(Date(), Date(), 0, null, 1001, "group1")
        assertTrue(dao.update(meeting, Pair("group1", 0)))
    }

    @Test
    fun testDelete() {
        assertTrue(dao.delete(Pair("group1", 1)))
    }
}