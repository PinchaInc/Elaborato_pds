package model

import repository.Repository

abstract class ConcreteModel: Model {
    val repo by lazy { makeRepository() }
    lateinit var user: User
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
        return true
    }

    override fun checkGroupName(groupName: String): Boolean = course.getGroups().none { it.name == groupName }

    override fun loadUser(username: Int): Boolean {
        val course = repo.readCourse(username)
        if (course == null)
            return false
        else {
            this.course = course
            var user: User? = course.getProfessors().find { it.id == username }
            if (user == null)
                user = course.getTutors().find { it.id == username }
            return if (user == null)
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

    override fun addWorkTrack(workTrack: WorkTrack): Boolean = course.addWorkTrack(workTrack)

    override fun assignWorkTrack(groupID: Int, workTrackID: Int): Boolean = course.assignWorkTrack(groupID, workTrackID)

    abstract fun makeRepository(): Repository
}