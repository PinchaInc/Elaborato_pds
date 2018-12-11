package model

import repository.Repository
import java.util.Observable

abstract class ConcreteModel : Observable(), Model {
    val repo by lazy { makeRepository() }
    private lateinit var user: User
    lateinit var course: Course

    override fun getGroup(groupID: Int): Group? = course.getGroup(groupID)

    override fun getWorkTrack(workTrackID: Int): WorkTrack? = course.getWorkTrack(workTrackID)

    override fun getMeeting(meetingID: Int): Meeting? = user.getMeeting(meetingID)

    override fun getAccount(username: Int): Account? = repo.readAccount(username)

    override fun addStudent(student: Student): Boolean {
        if (!course.addStudent(student))
            return false
        if (!repo.saveStudent(student)) {
            course.removeStudent(student)
            return false
        }
        setChanged()
        notifyObservers(student)
        return true
    }

    override fun getStudent(studentID: Int): Student? = course.getStudent(studentID)

    override fun addGroup(group: Group): Boolean {
        if (!course.addGroup(group))
            return false
        if (!repo.saveGroup(group)) {
            course.removeGroup(group)
            return false
        }
        setChanged()
        notifyObservers(group)
        return true
    }

    override fun checkGroupName(groupName: String): Boolean = course.getGroups().none { it.name == groupName }

    override fun loadUser(username: Int): Boolean {
        val course = repo.readCourse(username)
        return if (course == null)
            false
        else {
            this.course = course
            var user: User? = course.getProfessors().find { it.id == username }
            if (user == null)
                user = course.getTutors().find { it.id == username }
            if (user == null)
                false
            else {
                this.user = user
                true
            }
        }
    }

    override fun getStudents(): Array<Student> = course.getStudents()

    override fun getGroups(): Array<Group> = course.getGroups()

    override fun getWorkTracks(): Array<WorkTrack> = course.getWorkTracks()

    override fun addWorkTrack(workTrack: WorkTrack): Boolean {
        if (!course.addWorkTrack(workTrack))
            return false

        if (!repo.saveWorkTrack(workTrack)) {
            course.removeWorkTrack(workTrack)
            return false
        }

        setChanged()
        notifyObservers(workTrack)
        return true
    }

    override fun getMeetings(): Array<Meeting> = user.getMeetings()

    override fun addMeeting(meeting: Meeting): Boolean {
        val agenda = if (user.agenda == null)
            Agenda(user)
        else
            user.agenda!!
        if (!agenda.addMeeting(meeting))
            return false

        if(!repo.saveMeeting(meeting)) {
            agenda.removeMeeting(meeting)
            return false
        }

        setChanged()
        notifyObservers(meeting)
        return true
    }

    override fun addReview(meeting: Meeting, review: Review): Boolean {
        meeting.review = review

        if (!repo.saveReview(review))
            return false

        setChanged()
        notifyObservers(review)
        return true
    }

    override fun createWork(group: Group, workTrack: WorkTrack): Boolean {
        if (Work.createWork(group, workTrack) == null)
            return false

        if (!repo.saveGroup(group))
            return false

        setChanged()
        notifyObservers(course.getGroups())
        return true
    }

    abstract fun makeRepository(): Repository
}