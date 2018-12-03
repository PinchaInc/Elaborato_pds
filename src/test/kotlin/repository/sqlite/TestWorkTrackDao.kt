package repository.sqlite

import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import model.WorkTrack
import org.junit.Test

class TestWorkTrackDao {
    val dao = WorkTrackDao()

    @Test
    fun testCreate() {
        val workTrack = WorkTrack("title test", "body test")
        workTrack.id = 10
        assertTrue(dao.create(workTrack))
    }

    @Test
    fun testRead() {
        assertNotNull(dao.read(0))
    }

    @Test
    fun testUpdate() {
        val workTrack = WorkTrack("title test", "body test")
        workTrack.id = 1
        assertTrue(dao.update(workTrack, 0))
    }

    @Test
    fun testDelete() {
        assertTrue(dao.delete(10))
    }
}