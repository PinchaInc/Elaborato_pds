package model

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertNull
import junit.framework.TestCase.assertTrue
import org.junit.Test
import java.util.Date

class TestGroup {

    @Test
    fun testSetWork() {
        val group = Group("group")
        val work1 = Work(group, WorkTrack("title1", "body1"))
        group.work = work1
        assertEquals(work1, group.work)
        val work2 = Work(group, WorkTrack("title2", "body2"))
        group.work = work2
        assertEquals(work1, group.work)
    }

    @Test
    fun testCreateGroup() {
        val student1 = Student("name1", "surname1", 1)
        val student2 = Student("name2", "surname2", 2)
        val group = Group.createGroup("group", student1, student2)
        assertNotNull(group)
        assertEquals(2, group!!.membersSize())
        assertTrue(group.getMembers().contains(student1))
        assertTrue(group.getMembers().contains(student2))
        assertEquals(group, student1.group)
        assertEquals(group, student2.group)
    }

    @Test
    fun testCreateGroupErrorEmpty() {
        val group = Group.createGroup("group")
        assertNull(group)
    }

    @Test
    fun testCreateGroupErrorBusyMember() {
        val student = Student("name", "surname", 1)
        val group1 = Group("group1", student)
        val group2 = Group.createGroup("group2", student)
        assertNull(group2)
        assertEquals(group1, student.group)
    }

    @Test
    fun testRemoveMeeting() {
        val group = Group("group")
        val meeting = Meeting(group, Date(), Date())
        assertEquals(1, group.meetingsSize())
        assertEquals(meeting, group.getMeetings()[0])
        group.removeMeeting(meeting)
        assertEquals(0, group.meetingsSize())
    }
}