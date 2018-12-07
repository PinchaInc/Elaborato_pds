package views

import Util.MessageType
import controllers.StudentsController
import model.Model
import java.util.Observer

interface StudentsView: Observer {
    fun start()
    fun setController(controller: StudentsController)
    fun setModel(model: Model)
    fun showMessage(message: String, type: MessageType = MessageType.STANDARD)
}