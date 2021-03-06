package repository.sqlite

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import model.Course
import model.Group
import org.junit.Test

class TestGroupDao {
    val dao = GroupDao(DaoFactory())

    @Test
    fun testCreate() {
        val group = Group("test_group")
        assertTrue(dao.create(group))
    }

    @Test
    fun testRead() {
        val group = dao.read("group1")
        assertNotNull(group)
        assertEquals(3, group?.membersSize())
    }

    @Test
    fun testUpdate() {
        val group = Group("group1")
        val course = Course("Functional Programming", 2019)
        group.course = course
        assertTrue(dao.update(group))
    }

    @Test
    fun testDelete() {
        assertTrue(dao.delete("new_group"))
    }
}