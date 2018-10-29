package controllers

import model.Review

interface GroupsController {
    fun start()
    fun startStudents()
    fun startAgenda()
    fun assignWork(groupID: Int, workTrackID: Int)
    fun addReview(groupID: Int, meetingID: Int, review: Review)
}
