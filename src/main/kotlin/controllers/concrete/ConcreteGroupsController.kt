package controllers.concrete

import Util.MessageType
import controllers.Application
import controllers.GroupsController
import model.FinalReview
import model.Model
import model.Review
import model.Work
import views.GroupsView

class ConcreteGroupsController(
    private val view: GroupsView,
    private val model: Model,
    private val application: Application
) : GroupsController {

    override fun start() = view.start()

    override fun startStudents() = application.startStudents()

    override fun startAgenda() = application.startAgenda()

    override fun assignWork(groupID: Int, workTrackID: Int) {
        val group = model.getGroup(groupID)
        val workTrack = model.getWorkTrack(workTrackID)
        if (group != null && workTrack != null) {
            Work.createWork(group, workTrack)
            view.showMessage("ok")
        } else
            view.showMessage("error", MessageType.ERROR)
    }

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