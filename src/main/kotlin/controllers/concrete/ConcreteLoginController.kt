package controllers.concrete

import Util.MessageType
import controllers.Application
import controllers.LoginController
import model.Model
import views.LoginView

class ConcreteLoginController(
    private val view: LoginView,
    private val model: Model,
    private val application: Application
) : LoginController {

    override fun start() = view.start()

    override fun startAgenda() = application.startAgenda()

    override fun startGroups() = application.startGroups()

    override fun startStudents() = application.startStudents()

    override fun authenticate(username: String, password: String) {
        val account = model.getAccount(username)
        if (account == null || !account.authenticate(password))
            view.showMessage("Error", MessageType.ERROR)
        else
            view.showMessage("ok")
    }
}