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

    init {
        view.setModel(model)
        view.setController(this)
    }

    override fun start() = view.start()

    override fun startStudents() = application.startStudents()

    override fun startGroups() = application.startGroups()

    override fun addReview(meetingID: Int, reviewTitle: String, reviewBody: String, reviewRating: Int?) {
        if (reviewTitle.isBlank() || reviewBody.isBlank())
            view.showMessage("Compilare tutti i campi", MessageType.ERROR)
        else {
            val meeting = model.getMeeting(meetingID)
            if (meeting != null) {
                val review = if (reviewRating == null)
                    Review(reviewTitle, reviewBody)
                else FinalReview.makeFinalReview(reviewTitle, reviewBody, reviewRating)
                if (review == null)
                    view.showMessage("Il voto deve essere compreso tra 1 e 30", MessageType.ERROR)
                else {
                    if (model.addReview(meeting, review))
                        view.showMessage("Review aggiunta con successo")
                    else
                        view.showMessage("Non è stato possibile aggiungere la review, riprovare più tardi", MessageType.ERROR)
                }
            } else
                view.showMessage("Non è stato possibile trovare il meeting, riprovare più tradi", MessageType.ERROR)
        }
    }
}