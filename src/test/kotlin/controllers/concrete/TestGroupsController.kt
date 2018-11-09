package controllers.concrete

import Util.MessageType
import controllers.GroupsController
import junit.framework.TestCase.assertEquals
import model.Model
import org.junit.Test
import views.GroupsView
import java.util.Date

class TestGroupsController : TestControllersHelper() {

    val viewOk = object : GroupsView {
        override fun start() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun setController(controller: GroupsController) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun setModel(model: Model) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun showMessage(message: String, type: MessageType) {
            assertEquals(MessageType.STANDARD, type)
        }
    }

    val viewError = object : GroupsView {
        override fun start() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun setController(controller: GroupsController) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun setModel(model: Model) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun showMessage(message: String, type: MessageType) {
            assertEquals(MessageType.ERROR, type)
        }
    }

    val controllerOk = ConcreteGroupsController(viewOk, model, app)
    val controllerError = ConcreteGroupsController(viewError, modelError, app)

    @Test
    fun testAssignWork() {
        controllerOk.assignWork(1, 1)
    }

    @Test
    fun testAssignWorkError() {
        controllerError.assignWork(1, 1)
    }

    @Test
    fun testAddMeeting() {
        controllerOk.addMeeting(1, Date(), Date())
    }

    @Test
    fun testAddMeetingError() {
        controllerError.addMeeting(1, Date(), Date())
    }
}