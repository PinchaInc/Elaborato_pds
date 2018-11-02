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
        override fun getGroup(groupID: Int): Group? {
            return null
        }

        override fun getWorkTrack(workTrackID: Int): WorkTrack? {
            return null
        }

        override fun getMeeting(meetingID: Int): Meeting? {
            return null
        }

        override fun getAccount(username: String): Account? {
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
        val group = Group("name")
        val meeting = Meeting(group, Date(), Date())

        override fun getGroup(groupID: Int): Group? {
            return group
        }

        override fun getWorkTrack(workTrackID: Int): WorkTrack? {
            return WorkTrack("title", "body")
        }

        override fun getMeeting(meetingID: Int): Meeting? {
            return  meeting
        }

        override fun getAccount(username: String): Account? {
            return Account("username", "password".hashCode())
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