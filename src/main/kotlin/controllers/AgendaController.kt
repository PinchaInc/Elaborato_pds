package controllers

interface AgendaController {
    fun start()
    fun startStudents()
    fun startGroups()
    fun addReview(meetingID: Int, reviewTitle: String, reviewBody: String, reviewRating: Int? = null)
}
