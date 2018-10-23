package controllers

interface AgendaController {
    fun start()
    fun setApplication(app: Application): AgendaController
    fun startStudents()
    fun startGroups()
    //fun addMeeting(groupID: Int, meetingDate: Date) TODO
}
