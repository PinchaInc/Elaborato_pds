package views.swing

import controllers.Application
import model.Account
import model.Course
import model.Group
import model.Meeting
import model.Model
import model.Student
import model.WorkTrack
import views.ViewsFactory
import java.util.Observable

fun main(args: Array<String>) {
    val application = object : Application() {
        override fun makeViewsFactory(): ViewsFactory {
            return SwingFactory()
        }

        override fun makeModel(): Model {
            return object : Model, Observable() {
                val course: Course

                init {
                    course = Course("course1", 2018)
                    course.addStudent(Student("name1", "surname", 1))
                    course.addStudent(Student("name3", "surname", 3))
                    val student = Student("name2", "surname", 2)
                    val group = Group("group", student)
                    course.addStudent(student)
                    course.addGroup(group)
                }
                override fun getStudents(): Array<Student> {
                    return course.getStudents()
                }

                override fun getGroups(): Array<Group> {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getGroup(groupID: Int): Group? {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getWorkTrack(workTrackID: Int): WorkTrack? {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getMeeting(meetingID: Int): Meeting? {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun getAccount(username: Int): Account? {
                    return when (username) {
                        0 -> Account(0, "password".hashCode())
                        else -> null
                    }
                }

                override fun addStudent(student: Student): Boolean {
                    if (!course.addStudent(student))
                        return false
                    setChanged()
                    notifyObservers(student)
                    return true
                }

                override fun getStudent(studentID: Int): Student? {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun addGroup(group: Group): Boolean {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun checkGroupName(groupName: String): Boolean {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun loadUser(username: Int): Boolean {
                    return true
                }
            }
        }
    }
    application.start()
}