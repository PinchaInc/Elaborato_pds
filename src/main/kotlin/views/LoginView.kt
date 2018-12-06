package views

import Util.MessageType
import controllers.LoginController
import model.Model

interface LoginView {
    fun start()
    fun setController(controller: LoginController)
    fun setModel(model: Model)
    fun showMessage(message: String, type: MessageType = MessageType.STANDARD)
}