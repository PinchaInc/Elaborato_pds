package views

import Util.MessageType
import controllers.GroupsController
import controllers.StudentsController
import model.Model

interface StudentsView {
    fun start()
    fun setController(controller: StudentsController)
    fun setModel(model: Model)
    fun showMessage(message: String, type: MessageType = MessageType.STANDARD)
    fun insertNewStudentData()
    fun selectStudent()
    fun insertName()
}