package repository.sqlite

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import model.Course
import org.junit.Test

class TestCourseDao {

    val dao = CourseDao(DaoFactory())

    @Test
    fun testCreate() {
        val course = Course("test1", 1001)
        assertTrue(dao.create(course))
    }

    @Test
    fun testRead() {
        val course = dao.read(Pair("Functional Programming", 2019))
        assertNotNull(course)
        assertEquals(1, course?.tutorsSize())
        assertEquals(2, course?.professorsSize())
        assertEquals(3, course?.groupsSize())
        assertEquals(8, course?.studentsSize())
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