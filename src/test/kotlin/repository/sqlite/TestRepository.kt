package repository.sqlite

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import org.junit.Test
import repository.DaoFactory
import repository.Repository
import java.sql.PreparedStatement

class TestRepository {

    val repo = object : Repository() {
        override fun makeDaoFactory(): DaoFactory {
            return repository.sqlite.DaoFactory()
        }

        override fun prepareCourseStatament(username: Int): PreparedStatement {
            val sql = "select course_name, course_year from user where id = ?"
            val stm = Connection.getConnection().prepareStatement(sql)
            stm.setInt(1, username)
            return stm
        }
    }

    @Test
    fun testReadCourse() {
        val course = repo.readCourse(101)
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
}