package controllers.concrete

import Util.MessageType
import controllers.AgendaController
import junit.framework.TestCase
import junit.framework.TestCase.assertEquals
import model.FinalReview
import model.Model
import org.junit.Test
import views.AgendaView
import java.util.Date
import java.util.Observable

class TestAgendaController : TestControllersHelper() {

    val viewOk = object : AgendaView {
        override fun update(p0: Observable?, p1: Any?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun start() {}

        override fun setController(controller: AgendaController) {}

        override fun setModel(model: Model) {}

        override fun showMessage(message: String, type: MessageType) {
            assertEquals(MessageType.STANDARD, type)
        }
    }

    val viewError = object : AgendaView {
        override fun update(p0: Observable?, p1: Any?) {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun start() {}

        override fun setController(controller: AgendaController) {}

        override fun setModel(model: Model) {}

        override fun showMessage(message: String, type: MessageType) {
            assertEquals(MessageType.ERROR, type)
        }
    }

    val controllerOk = ConcreteAgendaController(viewOk, model, app)
    val controllerError = ConcreteAgendaController(viewError, modelError, app)

    @Test
    fun testAddReview() {
        controllerOk.addReview(1, "title", "body")
        val meeting = model.getMeeting(1)
        val review = meeting!!.review
        TestCase.assertNotNull(review)
        TestCase.assertTrue(review !is FinalReview)
    }

    @Test
    fun testAddReviewError() {
        controllerError.addReview(1, "title", "body")
    }

    @Test
    fun testAddFinalReview() {
        controllerOk.addReview(1, "title", "body", 10)
        val meeting = model.getMeeting(1)
        val review = meeting!!.review
        TestCase.assertNotNull(review)
        TestCase.assertTrue(review is FinalReview)
    }

    @Test
    fun testAddFinalReviewError() {
        controllerError.addReview(1, "title", "body", 10)
    }
}