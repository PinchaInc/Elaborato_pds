package model.model

import junit.framework.TestCase
import model.ConcreteModel
import org.junit.Test
import repository.DaoFactory
import repository.Repository
import java.sql.PreparedStatement

class TestConcreteModel {
    val model = object : ConcreteModel() {
        override fun makeRepository(): Repository {
            return object : Repository() {
                override fun makeDaoFactory(): DaoFactory {
                    return repository.sqlite.DaoFactory()
                }

                override fun prepareCourseStatament(username: Int): PreparedStatement {
                    val sql = "select course_name, course_year from user where id = ?"
                    val stm = repository.sqlite.Connection.getConnection().prepareStatement(sql)
                    stm.setInt(1, username)
                    return stm
                }
            }
        }
    }

    @Test
    fun testRead() {
        model.loadUser(101)
        val course = model.course
        TestCase.assertNotNull(course)
        TestCase.assertEquals(1, course.tutorsSize())
        TestCase.assertEquals(2, course.professorsSize())
        TestCase.assertEquals(3, course.groupsSize())
        TestCase.assertEquals(8, course.studentsSize())
        TestCase.assertEquals(2, course.workTracksSize())
        val prof1 = course.getProfessors().find { it.id == 101 }
        TestCase.assertNotNull(prof1)
        TestCase.assertNotNull(prof1!!.agenda)
        TestCase.assertEquals(3, prof1.agenda!!.meetingSize())
        val prof2 = course.getProfessors().find { it.id == 102 }
        TestCase.assertNotNull(prof2)
        TestCase.assertNotNull(prof2!!.agenda)
        TestCase.assertEquals(0, prof2.agenda!!.meetingSize())
        val tutor = course.getTutors().find { it.id == 1001 }
        TestCase.assertNotNull(tutor)
        TestCase.assertNotNull(tutor!!.agenda)
        TestCase.assertEquals(1, tutor.agenda!!.meetingSize())
        val group1 = course.getGroups().find { it.name == "group1" }
        TestCase.assertNotNull(group1)
        TestCase.assertEquals(3, group1!!.membersSize())
        TestCase.assertEquals(2, group1.meetingsSize())
        TestCase.assertEquals(1, group1.work!!.reviewsSize())
        val group2 = course.getGroups().find { it.name == "group2" }
        TestCase.assertNotNull(group2)
        TestCase.assertEquals(1, group2!!.membersSize())
        TestCase.assertEquals(2, group2.meetingsSize())
        TestCase.assertEquals(2, group2.work!!.reviewsSize())
    }

    @Test
    fun error() {
        TestCase.assertEquals(1,2)
    }
}