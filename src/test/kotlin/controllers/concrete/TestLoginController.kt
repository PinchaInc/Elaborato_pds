package controllers.concrete

import Util.MessageType
import controllers.LoginController
import junit.framework.TestCase.assertEquals
import model.Model
import org.junit.Test
import views.LoginView

class TestLoginController : TestControllersHelper() {

    val viewOk = object : LoginView {
        override fun start() {}

        override fun setController(controller: LoginController) {}

        override fun setModel(model: Model) {}

        override fun showMessage(message: String, type: MessageType) {
            assertEquals(MessageType.STANDARD, type)
        }
    }

    val viewError = object : LoginView {
        override fun start() {}

        override fun setController(controller: LoginController) {}

        override fun setModel(model: Model) {}

        override fun showMessage(message: String, type: MessageType) {
            assertEquals(MessageType.ERROR, type)
        }
    }

    //@Test non riesce ad avviare la schermata perchè non implementata
    fun testAuthenticate() {
        val controller = ConcreteLoginController(viewOk, model, app)
        controller.authenticate("username", "password")
    }

    @Test
    fun testAuthenticateErrorWrongUsername() {
        val controller = ConcreteLoginController(viewError, modelError, app)
        controller.authenticate("username", "password")
    }

    @Test
    fun testAuthenticateErrorWrongPassword() {
        val controller = ConcreteLoginController(viewError, model, app)
        controller.authenticate("username", "error")
    }
}