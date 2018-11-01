package controllers

interface GroupsController {
    fun start()
    fun startStudents()
    fun startAgenda()
    fun assignWork(groupID: Int, workTrackID: Int)
    fun addReview(groupID: Int, meetingID: Int, reviewTitle: String, reviewBody: String, reviewRating: Int? = null)
}
