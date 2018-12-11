package controllers.concrete

import Util.MessageType
import controllers.StudentsController
import junit.framework.TestCase.assertEquals
import model.Model
import org.junit.Test
import views.StudentsView
import java.util.Observable

class TestStudentsController: TestControllersHelper() {

    val viewOk = object : StudentsView {
        override fun update(p0: Observable?, p1: Any?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun start() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun setController(controller: StudentsController) {}

        override fun setModel(model: Model) {}

        override fun showMessage(message: String, type: MessageType) {
            assertEquals(MessageType.STANDARD, type)
        }
    }

    val viewError = object : StudentsView {
        override fun update(p0: Observable?, p1: Any?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun start() {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun setController(controller: StudentsController) {}

        override fun setModel(model: Model) {}

        override fun showMessage(message: String, type: MessageType) {
            assertEquals(MessageType.ERROR, type)
        }
    }

    val controllerOk = ConcreteStudentsController(viewOk, model, app)
    val controllerError = ConcreteStudentsController(viewError, modelError, app)
    val controller = ConcreteStudentsController(viewError, model, app)

    @Test
    fun testAddStudents() {
        controllerOk.addStudent("name", "surname", 1)
    }

    @Test
    fun testAddStudentsError() {
        controllerError.addStudent("name", "surname", 1)
    }

    @Test
    fun testAddGroup() {
        controllerOk.addGroup("group", 1, 2)
    }

    @Test
    fun testAddGroupErrorOnAdd() {
        controller.addGroup("error", 1, 1)
    }

    @Test
    fun testAddGroupErrorEmptyStudents() {
        controller.addGroup("group")
    }

    @Test
    fun testAddGroupErrorNullStudent() {
        controller.addGroup("group", 1, 10)
    }

    @Test
    fun testAddGroupErrorBusyStudent() {
        controller.addGroup("group", 2, 3)
    }
}
