package views.swing

import controllers.Application
import model.Account
import model.Agenda
import model.Course
import model.Group
import model.Meeting
import model.Model
import model.Review
import model.Student
import model.Tutor
import model.User
import model.Work
import model.WorkTrack
import views.ViewsFactory
import java.util.Date
import java.util.Observable

fun main(args: Array<String>) {
    val application = object : Application() {
        override fun makeViewsFactory(): ViewsFactory {
            return SwingFactory()
        }

        override fun makeModel(): Model {
            return object : Model, Observable() {
                val course: Course
                val user: User

                init {
                    course = Course("course1", 2018)
                    course.addStudent(Student("name1", "surname", 1))
                    course.addStudent(Student("name3", "surname", 3))
                    val student = Student("name2", "surname", 2)
                    val group = Group("group", student)
                    course.addStudent(student)
                    course.addGroup(group)
                    val wt = WorkTrack("title", "body")
                    course.addWorkTrack(wt)
                    course.addWorkTrack(WorkTrack("title1", "body"))
                    course.addWorkTrack(WorkTrack("title2", "body"))
                    Work.createWork(group, wt)
                    user = Tutor("name", "surname", "email", 1223)
                    course.addTeacher(user)
                    val meeting = Meeting(group, Date(), Date())
                    val agenda = Agenda(user)
                    agenda.addMeeting(meeting)
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

                override fun getGroup(groupID: Int): Group? {
                    return course.getGroup(groupID)
                }

                override fun getWorkTrack(workTrackID: Int): WorkTrack? {
                    return course.getWorkTrack(workTrackID)
                }

                override fun getMeeting(meetingID: Int): Meeting? {
                    return user.getMeeting(meetingID)
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
                        return false
                    setChanged()
                    notifyObservers(workTrack)
                    return true
                }

                override fun getMeetings(): Array<Meeting> {
                    return user.getMeetings()
                }

                override fun addMeeting(meeting: Meeting): Boolean {
                    val agenda = if (user.agenda == null)
                        Agenda(user)
                    else
                        user.agenda!!
                    return if (agenda.addMeeting(meeting)) {
                        setChanged()
                        notifyObservers(meeting)
                        true
                    } else false
                }

                override fun addReview(meeting: Meeting, review: Review): Boolean {
                    meeting.review = review
                    setChanged()
                    notifyObservers(review)
                    return true
                }

                override fun createWork(group: Group, workTrack: WorkTrack): Boolean {
                    val work = Work.createWork(group, workTrack)
                    return if (work != null) {
                        setChanged()
                        notifyObservers(course.getGroups())
                        true
                    } else false
                }
            }
        }
    }
    application.start()
}