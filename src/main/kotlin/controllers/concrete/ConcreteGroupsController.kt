package controllers.concrete

import Util.MessageType
import controllers.Application
import controllers.GroupsController
import model.Meeting
import model.Model
import model.Work
import views.GroupsView
import java.util.Date

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

    override fun addMeeting(groupID: Int, stratDate: Date, endDate: Date) {
        val group = model.getGroup(groupID)
        if (group != null) {
            Meeting(group, stratDate, endDate)
            view.showMessage("OK")
        } else
            view.showMessage("error", MessageType.ERROR)
    }
}