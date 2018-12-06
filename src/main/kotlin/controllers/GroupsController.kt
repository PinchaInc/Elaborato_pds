package controllers

import java.util.Date

interface GroupsController {
    fun start()
    fun startStudents()
    fun startAgenda()
    fun assignWork(groupID: Int, workTrackID: Int)
    fun addMeeting(groupID: Int, stratDate: Date, endDate: Date)
}
