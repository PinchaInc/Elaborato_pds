package controllers

import java.util.Date

interface AgendaController {
    fun setApplication(app: Application): AgendaController
    fun start()
    fun startStudents()
    fun startGroups()
    fun addMeeting(groupID: Int, stratDate: Date, endDate: Date)
}
