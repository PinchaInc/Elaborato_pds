package repository.sqlite

import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import model.Course
import model.Professor
import model.Tutor
import org.junit.Test
import java.util.Date

class TestUserDao {

    val dao = UserDao()

    @Test
    fun testCreate() {
        val course = Course("test1", 1001)
        val tutor = Tutor("tutor1", "surname1", Date(), "email", 1001)
        tutor.course = course
        assertTrue(dao.create(tutor))
    }

    @Test
    fun testCreateNullCourse() {
        val prof = Professor("prof1", "surname1", Date(), "email", 101)
        assertTrue(dao.create(prof))
    }

    @Test
    fun testRead() {
        val user = dao.read(101)
        assertNotNull(user)
    }

    @Test
    fun testUpdate() {
        val tutor = Tutor("tutor1", "new surname1", Date(), "new email", 1001)
        assertTrue(dao.update(tutor, 1001))
    }

    @Test
    fun testDelete() {
        assertTrue(dao.delete(1001))
    }
}