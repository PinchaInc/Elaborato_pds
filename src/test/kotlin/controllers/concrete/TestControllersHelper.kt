package controllers.concrete

import controllers.Application
import model.Account
import model.Group
import model.Meeting
import model.Model
import model.Student
import model.WorkTrack
import views.ViewsFactory
import java.util.Date

open class TestControllersHelper {
    val modelError = object : Model {
        override fun getStudents(): Array<Student> {
            return ArrayList<Student>().toTypedArray()
        }

        override fun getGroups(): Array<Group> {
            return ArrayList<Group>().toTypedArray()
        }

        override fun loadUser(username: Int): Boolean {
            return false
        }

        override fun checkGroupName(groupName: String): Boolean {
            return false
        }

        override fun getGroup(groupID: Int): Group? {
            return null
        }

        override fun getWorkTrack(workTrackID: Int): WorkTrack? {
            return null
        }

        override fun getMeeting(meetingID: Int): Meeting? {
            return null
        }

        override fun getAccount(username: Int): Account? {
            return null
        }

        override fun addStudent(student: Student): Boolean {
            return false
        }

        override fun getStudent(studentID: Int): Student? {
            return null
        }

        override fun addGroup(group: Group): Boolean {
            return false
        }
    }

    val model = object : Model {
        override fun getStudents(): Array<Student> {
            return ArrayList<Student>().toTypedArray()
        }

        override fun getGroups(): Array<Group> {
            return ArrayList<Group>().toTypedArray()
        }

        override fun loadUser(username: Int): Boolean {
            return true
        }

        override fun checkGroupName(groupName: String): Boolean {
            return true
        }

        val group = Group("name")
        val meeting = Meeting(group, Date(), Date())

        override fun getGroup(groupID: Int): Group? {
            return group
        }

        override fun getWorkTrack(workTrackID: Int): WorkTrack? {
            return WorkTrack("title", "body")
        }

        override fun getMeeting(meetingID: Int): Meeting? {
            return meeting
        }

        override fun getAccount(username: Int): Account? {
            return Account(1001, "password".hashCode())
        }

        override fun addStudent(student: Student): Boolean {
            return true
        }

        override fun getStudent(studentID: Int): Student? {
            return when (studentID) {
                1 -> Student("name", "surname", 1)
                2 -> Student("name", "surname", 2)
                3 -> {
                    val student = Student("name", "surname", 3)
                    student.group = group
                    student
                }
                else -> null
            }
        }

        override fun addGroup(group: Group): Boolean {
            return group.name != "error"
        }
    }

    val app = object : Application() {
        override fun makeViewsFactory(): ViewsFactory {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}
