package views

import Util.MessageType
import controllers.GroupsController
import model.Model
import java.util.Observer

interface GroupsView: Observer {
    fun start()
    fun setController(controller: GroupsController)
    fun setModel(model: Model)
    fun showMessage(message: String, type: MessageType = MessageType.STANDARD)
}