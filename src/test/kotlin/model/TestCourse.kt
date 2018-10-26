package model

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotSame
import junit.framework.TestCase.assertNull
import org.junit.Test
import java.util.Date

class TestCourse {

    @Test
    fun testAddendRemoveStudent() {
        val course = Course("course", 0)
        val student1 = Student("name1", "surname1", 1)
        val student2 = Student("name2", "surname2", 2)
        course.addStudent(student1)
        assertEquals(1, course.studentsSize())
        assertEquals(course, student1.course)
        course.addStudent(student1)
        assertEquals(1, course.studentsSize())
        course.addStudent(student2)
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
        course.addStudent(student1)
        course.addStudent(student2)
        assertEquals(1, course.studentsSize())
    }

    @Test
    fun testAddStudentsBusy() {
        val course1 = Course("course1", 0)
        val course2 = Course("course2", 0)
        val student = Student("name", "surname", 1)
        student.course = course1
        course2.addStudent(student)
        assertEquals(0, course1.studentsSize())
        assertEquals(1, course2.studentsSize())
    }

    @Test
    fun testAddAndRemoveGroup() {
        val course = Course("course", 0)
        val group = Group("group", arrayOf())
        course.addGroup(group)
        assertEquals(1, course.groupsSize())
        course.addGroup(group)
        assertEquals(1, course.groupsSize())
        course.removeGroup(group)
        assertEquals(0, course.groupsSize())
    }

    @Test
    fun testAddGroupErrorSameName() {
        val course = Course("course", 0)
        val group1 = Group("group", arrayOf())
        val group2 = Group("group", arrayOf(
            Student("name", "surname", 1)
        ))
        course.addGroup(group1)
        course.addGroup(group2)
        assertNotSame(group1, group2)
        assertEquals(1, course.groupsSize())

    }

    @Test
    fun testAddAndRemoveWorkTrack() {
        val course = Course("course", 0)
        val workTrack = WorkTrack("title", "body")
        course.addWorkTrack(workTrack)
        assertEquals(1, course.workTracksSize())
        course.addWorkTrack(workTrack)
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
        course.addTeacher(professor)
        assertEquals(1, course.professorsSize())
        assertEquals(0, course.tutorsSize())
        course.addTeacher(professor)
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
        course.addTeacher(tutor)
        assertEquals(0, course.professorsSize())
        assertEquals(1, course.tutorsSize())
        course.addTeacher(tutor)
        assertEquals(0, course.professorsSize())
        assertEquals(1, course.tutorsSize())
        course.removeTeacher(tutor)
        assertEquals(0, course.tutorsSize())
    }
}