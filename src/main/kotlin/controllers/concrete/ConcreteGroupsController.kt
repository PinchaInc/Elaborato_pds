package controllers.concrete

import Util.MessageType
import controllers.Application
import controllers.GroupsController
import model.Meeting
import model.Model
import model.Work
import model.WorkTrack
import views.GroupsView
import java.util.Date

class ConcreteGroupsController(
    private val view: GroupsView,
    private val model: Model,
    private val application: Application
) : GroupsController {

    init {
        view.setModel(model)
        view.setController(this)
    }

    override fun start() = view.start()

    override fun startStudents() = application.startStudents()

    override fun startAgenda() = application.startAgenda()

    override fun assignWork(groupID: Int, workTrackID: Int) {
        val group = model.getGroup(groupID)
        val workTrack = model.getWorkTrack(workTrackID)
        if (group != null && workTrack != null) {
            if (model.createWork(group, workTrack))
                view.showMessage("Work track aggiunto con successo")
            else
                view.showMessage("Selezionare un gruppo senza work track", MessageType.ERROR)
        } else
            view.showMessage("Si è verificato un errore, riprovare più tardi", MessageType.ERROR)
    }

    override fun addMeeting(groupID: Int, stratDate: Date, endDate: Date) {
        val group = model.getGroup(groupID)
        if (group?.work != null) {
            val meeting = Meeting.makeMeeting(group, stratDate)
            if (meeting == null)
                view.showMessage("Non puoi tornare indietro nel tempo", MessageType.ERROR)
            else {
                if (model.addMeeting(meeting))
                    view.showMessage("Meeting aggiunto con successo")
                else
                    view.showMessage("Numero massimo di meeting ragiunto", MessageType.ERROR)
            }
        } else
            view.showMessage("Il gruppo non ha ancora un elaborato", MessageType.ERROR)
    }

    override fun addWorkTrack(title: String, body: String) {
        if (title.isBlank() || body.isBlank())
            view.showMessage("Compilare tutti i campi", MessageType.ERROR)
        else {
            if (model.addWorkTrack(WorkTrack(title, body)))
                view.showMessage("Work track aggiunta con successo")
            else
                view.showMessage("Titolo già presente", MessageType.ERROR)
        }
    }
}