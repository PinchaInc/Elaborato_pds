package model

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNull
import org.junit.Test

class TestStudent {

    @Test
    fun testSetCourse() {
        val course1 = Course("course1", 1)
        val course2 = Course("course2", 2)
        val student = Student("name", "surname", 1)
        student.course = course1
        assertEquals(course1, student.course)
        assertEquals(1, course1.studentsSize())
        student.course = course2
        assertEquals(course2, student.course)
        assertEquals(1, course2.studentsSize())
        assertEquals(0, course1.studentsSize())
        student.course = null
        assertNull(student.course)
        assertEquals(0, course2.studentsSize())
        assertEquals(0, course1.studentsSize())
    }
}