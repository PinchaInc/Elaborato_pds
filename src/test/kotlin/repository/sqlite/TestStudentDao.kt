package repository.sqlite

import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import model.Course
import model.Group
import model.Student
import org.junit.Test

class TestStudentDao {
    val dao = StudentDao()

    @Test
    fun testCreate() {
        val student = Student("name1", "surname", 10)
        val group = Group("group", student)
        val course = Course("test1", 1001)
        student.course = course

        assertTrue(dao.create(student))
    }

    @Test
    fun testCreateGroupNull() {
        val student = Student("name1", "surname", 11)
        val course = Course("test1", 1001)
        student.course = course

        assertTrue(dao.create(student))
    }

    @Test
    fun testCreateCourseNull() {
        val student = Student("name1", "surname", 12)
        val group = Group("group", student)

        assertTrue(dao.create(student))
    }

    @Test
    fun testRead() {
        assertNotNull(dao.read(11))
    }

    @Test
    fun testUpdate() {
        val student = Student("name1", "surname", 10)
        assertTrue(dao.update(student))
    }

    @Test
    fun testDelete() {
        assertTrue(dao.delete(1))
    }
}