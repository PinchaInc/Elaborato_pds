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
                    course.addWorkTrack(WorkTrack("title", "body"))
                    course.addWorkTrack(WorkTrack("title1", "body"))
                    course.addWorkTrack(WorkTrack("title2", "body"))
                }

                override fun getStudents(): Array<Student> {
                    return course.getStudents()
                }

                override fun getGroups(): Array<Group> {
                    return course.getGroups()
                }

                override fun getWorkTracks(): Array<WorkTrack> {
                    return course.getWorkTracks()
                }

                override fun assignWorkTrack(groupID: Int, workTrackID: Int): Boolean {
                    if (!course.assignWorkTrack(groupID, workTrackID))
                        return false
                    setChanged()
                    notifyObservers(course.getGroups())
                    return true
                }

                override fun getGroup(groupID: Int): Group? {
                    return course.getGroup(groupID)
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
                    return course.getStudent(studentID)
                }

                override fun addGroup(group: Group): Boolean {
                    if (course.addGroup(group)) {
                        setChanged()
                        notifyObservers(group)
                        return true
                    }
                    return false
                }

                override fun checkGroupName(groupName: String): Boolean {
                    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
                }

                override fun loadUser(username: Int): Boolean {
                    return true
                }

                override fun addWorkTrack(workTrack: WorkTrack): Boolean {
                    if (!course.addWorkTrack(workTrack))
                        return true
                    setChanged()
                    notifyObservers(workTrack)
                    return true
                }
            }
        }
    }
    application.start()
}