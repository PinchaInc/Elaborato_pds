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

    init {
        view.setModel(model)
        view.setController(this)
    }

    override fun start() = view.start()

    override fun startAgenda() = application.startAgenda()

    override fun startGroups() = application.startGroups()

    override fun startStudents() = application.startStudents()

    override fun authenticate(username: Int, password: String) {
        if (password.isBlank())
            view.showMessage("Inserisci la password", MessageType.ERROR)
        else {
            val account = model.getAccount(username)
            if (account == null || !account.authenticate(password))
                view.showMessage("Username o password errati", MessageType.ERROR)
            else {
                if (model.loadUser(username))
                    application.startStudents()
                else
                    view.showMessage("Non è stato possibile recuperare le informazioni dal database", MessageType.ERROR)
            }
        }
    }
}