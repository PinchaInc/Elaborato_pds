package model

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertNotSame
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import org.junit.Test
import java.util.Date

class TestCourse {

    @Test
    fun testAddendRemoveStudent() {
        val course = Course("course", 0)
        val student1 = Student("name1", "surname1", 1)
        val student2 = Student("name2", "surname2", 2)
        assertTrue(course.addStudent(student1))
        assertEquals(1, course.studentsSize())
        assertEquals(course, student1.course)
        assertFalse(course.addStudent(student1))
        assertEquals(1, course.studentsSize())
        assertTrue(course.addStudent(student2))
        assertEquals(2, course.studentsSize())
        course.removeStudent(student1)
        assertEquals(1, course.studentsSize())
        assertNull(student1.course)
    }

    @Test
    fun testAddStudentErrorSameID() {
        val course = Course("course", 0)
        val student1 = Student("name1", "surname1", 1)
        val student2 = Student("name2", "surname2", 1)
        assertTrue(course.addStudent(student1))
        assertFalse(course.addStudent(student2))
        assertEquals(1, course.studentsSize())
    }

    @Test
    fun testAddStudentsBusy() {
        val course1 = Course("course1", 0)
        val course2 = Course("course2", 0)
        val student = Student("name", "surname", 1)
        student.course = course1
        assertTrue(course2.addStudent(student))
        assertEquals(0, course1.studentsSize())
        assertEquals(1, course2.studentsSize())
        assertEquals(course2, student.course)
    }

    @Test
    fun testAddAndRemoveGroup() {
        val course = Course("course", 0)
        val group = Group("group")
        assertTrue(course.addGroup(group))
        assertEquals(1, course.groupsSize())
        assertFalse(course.addGroup(group))
        assertEquals(1, course.groupsSize())
        course.removeGroup(group)
        assertEquals(0, course.groupsSize())
    }

    @Test
    fun testAddGroupErrorSameName() {
        val course = Course("course", 0)
        val group1 = Group("group")
        val group2 = Group("group", Student("name", "surname", 1))
        assertTrue(course.addGroup(group1))
        assertFalse(course.addGroup(group2))
        assertNotSame(group1, group2)
        assertEquals(1, course.groupsSize())

    }

    @Test
    fun testAddAndRemoveWorkTrack() {
        val course = Course("course", 0)
        val workTrack = WorkTrack("title", "body")
        assertTrue(course.addWorkTrack(workTrack))
        assertEquals(1, course.workTracksSize())
        assertFalse(course.addWorkTrack(workTrack))
        assertEquals(1, course.workTracksSize())
        course.removeWorkTrack(workTrack)
        assertEquals(0, course.workTracksSize())
    }

    @Test
    fun testAddAndRemoveProfessor() {
        val course = Course("course", 0)
        val professor = Professor(
            "name",
            "surname",
            Date(),
            "email",
            1
        )
        assertTrue(course.addTeacher(professor))
        assertEquals(1, course.professorsSize())
        assertEquals(0, course.tutorsSize())
        assertFalse(course.addTeacher(professor))
        assertEquals(1, course.professorsSize())
        assertEquals(0, course.tutorsSize())
        course.removeTeacher(professor)
        assertEquals(0, course.professorsSize())
    }

    @Test
    fun testAddAndRemoveTutor() {
        val course = Course("course", 0)
        val tutor = Tutor(
            "name",
            "surname",
            Date(),
            "email",
            1
        )
        assertTrue(course.addTeacher(tutor))
        assertEquals(0, course.professorsSize())
        assertEquals(1, course.tutorsSize())
        assertFalse(course.addTeacher(tutor))
        assertEquals(0, course.professorsSize())
        assertEquals(1, course.tutorsSize())
        course.removeTeacher(tutor)
        assertEquals(0, course.tutorsSize())
    }
}