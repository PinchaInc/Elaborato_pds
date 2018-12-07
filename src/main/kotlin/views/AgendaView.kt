package views

import Util.MessageType
import controllers.AgendaController
import model.Model
import java.util.Observer

interface AgendaView: Observer {
    fun start()
    fun selectGroup()
    fun setController(controller: AgendaController)
    fun setModel(model: Model)
    fun showMessage(message: String, type: MessageType = MessageType.STANDARD)
}