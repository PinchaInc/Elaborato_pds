package controllers.concrete

import Util.MessageType
import controllers.AgendaController
import junit.framework.TestCase.assertEquals
import model.Model
import org.junit.Test
import views.AgendaView
import java.util.Date

class TestAgendaController: TestControllersHelper() {

    val viewOk = object : AgendaView {
        override fun start() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun selectGroup() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun setController(controller: AgendaController) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun setModel(model: Model) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun showMessage(message: String, type: MessageType) {
            assertEquals(MessageType.STANDARD, type)
        }
    }

    val viewError = object : AgendaView {
        override fun start() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun selectGroup() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun setController(controller: AgendaController) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun setModel(model: Model) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun showMessage(message: String, type: MessageType) {
            assertEquals(MessageType.ERROR, type)
        }
    }

    @Test
    fun testAddMeeting() {
        val controller = ConcreteAgendaController(viewOk, model, app)
        controller.addMeeting(1, Date(), Date())
    }

    @Test
    fun testAddMeetingError() {
        val controller = ConcreteAgendaController(viewError, modelError, app)
        controller.addMeeting(1, Date(), Date())
    }

}