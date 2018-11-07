package model

// TODO
interface Model {
    fun getGroup(groupID: Int): Group?
    fun getWorkTrack(workTrackID: Int): WorkTrack?
    fun getMeeting(meetingID: Int): Meeting?
    fun getAccount(username: String): Account?
    fun addStudent(student: Student): Boolean
    fun getStudent(studentID: Int): Student?
    fun addGroup(group: Group): Boolean
    fun checkGroupName(groupName: String): Boolean
    fun loadUser(username: String): Boolean
}
