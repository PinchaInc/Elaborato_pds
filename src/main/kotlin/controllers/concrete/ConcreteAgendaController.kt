package controllers.concrete

import Util.MessageType
import controllers.AgendaController
import controllers.Application
import model.FinalReview
import model.Model
import model.Review
import views.AgendaView

class ConcreteAgendaController(
    private val view: AgendaView,
    private val model: Model,
    private val application: Application
) : AgendaController {

    override fun start() = view.start()

    override fun startStudents() = application.startStudents()

    override fun startGroups() = application.startGroups()

    override fun addReview(meetingID: Int, reviewTitle: String, reviewBody: String, reviewRating: Int?) {
        val meeting = model.getMeeting(meetingID)
        if (meeting != null) {
            val review = if (reviewRating == null)
                Review(reviewTitle, reviewBody)
            else FinalReview(reviewTitle, reviewBody, reviewRating)
            meeting.review = review
            view.showMessage("ok")
        } else
            view.showMessage("error", MessageType.ERROR)
    }
}