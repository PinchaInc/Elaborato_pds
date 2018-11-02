package controllers.concrete

import Util.MessageType
import controllers.AgendaController
import controllers.Application
import model.Model
import model.Meeting
import views.AgendaView
import java.util.Date

class ConcreteAgendaController(
    private val view: AgendaView,
    private val model: Model,
    private val application: Application
) : AgendaController {

    override fun start() = view.start()

    override fun startStudents() = application.startStudents()

    override fun startGroups() = application.startGroups()

    override fun addMeeting(groupID: Int, stratDate: Date, endDate: Date) {
        val group = model.getGroup(groupID)
        if (group != null){
            Meeting(group, stratDate, endDate)
            view.showMessage("OK")
        } else
            view.showMessage("error", MessageType.ERROR)
    }
}