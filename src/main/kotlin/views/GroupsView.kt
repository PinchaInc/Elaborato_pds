package views

import Util.MessageType
import controllers.GroupsController
import model.Model

interface GroupsView {
    fun start()
    fun setController(controller: GroupsController)
    fun setModel(model: Model)
    fun showMessage(message: String, type: MessageType = MessageType.STANDARD)
}