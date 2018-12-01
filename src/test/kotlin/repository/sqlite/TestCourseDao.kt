package repository.sqlite

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import model.Course
import org.junit.Test

class TestCourseDao {

    val dao = CourseDao()

    @Test
    fun testCreate() {
        val course = Course("test1", 1001)
        assertTrue(dao.create(course))
    }

    @Test
    fun testRead() {
        val course = dao.read(Pair("test1", 1001))
        assertNotNull(course)
        assertEquals("test1", course?.name)
        assertEquals(1001, course?.year)
    }

    @Test
    fun testUpdate() {
        val course = Course("test1", 1111)
        assertTrue(dao.update(course, Pair("test1", 1001)))
    }

    @Test
    fun testDelete() {
        assertTrue(dao.delete(Pair("test1", 1111)))
    }
}