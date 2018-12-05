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
        assertEquals(2, course!!.workTracksSize())
        val prof1 = course.getProfessors().find { it.id == 101 }
        assertNotNull(prof1)
        assertNotNull(prof1!!.agenda)
        assertEquals(3, prof1.agenda!!.meetingSize())
        val prof2 = course.getProfessors().find { it.id == 102 }
        assertNotNull(prof2)
        assertNotNull(prof2!!.agenda)
        assertEquals(0, prof2.agenda!!.meetingSize())
        val tutor = course.getTutors().find { it.id == 1001 }
        assertNotNull(tutor)
        assertNotNull(tutor!!.agenda)
        assertEquals(1, tutor.agenda!!.meetingSize())
        val group1 = course.getGroups().find { it.name == "group1" }
        assertNotNull(group1)
        assertEquals(3, group1!!.membersSize())
        assertEquals(2, group1.meetingsSize())
        assertEquals(1, group1.work!!.reviewsSize())
        val group2 = course.getGroups().find { it.name == "group2" }
        assertNotNull(group2)
        assertEquals(1, group2!!.membersSize())
        assertEquals(2, group2.meetingsSize())
        assertEquals(2, group2.work!!.reviewsSize())
    }

    @Test
    fun testUpdate() {
        val course = Course("test1", 1111)
        assertTrue(dao.update(course))
    }

    @Test
    fun testDelete() {
        assertTrue(dao.delete(Pair("test1", 1111)))
    }
}