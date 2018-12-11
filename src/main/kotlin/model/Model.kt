package model

interface Model {
    fun getGroup(groupID: Int): Group?
    fun getWorkTrack(workTrackID: Int): WorkTrack?
    fun getMeeting(meetingID: Int): Meeting?
    fun getAccount(username: Int): Account?
    fun addStudent(student: Student): Boolean
    fun getStudent(studentID: Int): Student?
    fun addGroup(group: Group): Boolean
    fun checkGroupName(groupName: String): Boolean
    fun loadUser(username: Int): Boolean
    fun getStudents(): Array<Student>
    fun getGroups(): Array<Group>
    fun getWorkTracks(): Array<WorkTrack>
    fun addWorkTrack(workTrack: WorkTrack): Boolean
    fun getMeetings(): Array<Meeting>
    fun addMeeting(meeting: Meeting): Boolean
    fun addReview(meeting: Meeting, review: Review): Boolean
    fun createWork(group: Group, workTrack: WorkTrack): Boolean
}
