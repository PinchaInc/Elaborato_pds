package controllers

interface AgendaController {
    fun start()
    fun setApplication(app: Application): AgendaController
    //fun addMeeting(groupID: Int, meetingDate: Date) TODO
}
