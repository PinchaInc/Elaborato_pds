package controllers.concrete

import Util.MessageType
import controllers.GroupsController
import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import model.FinalReview
import model.Model
import org.junit.Test
import views.GroupsView

class TestGroupsController: TestControllersHelper() {

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
    fun testAddReview() {
        controllerOk.addReview(1, "title", "body")
        val meeting = model.getMeeting(1)
        val review = meeting!!.review
        assertNotNull(review)
        assertTrue(review !is FinalReview)
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
        assertNotNull(review)
        assertTrue(review is FinalReview)
    }

    @Test
    fun testAddFinalReviewError() {
        controllerError.addReview(1, "title", "body", 10)
    }
}