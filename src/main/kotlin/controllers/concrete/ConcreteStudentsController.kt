package controllers.concrete

import Util.MessageType
import controllers.Application
import controllers.StudentsController
import model.Group
import model.Model
import model.Student
import views.StudentsView

class ConcreteStudentsController(
    private val view: StudentsView,
    private val model: Model,
    private val application: Application
) : StudentsController {

    init {
        view.setModel(model)
        view.setController(this)
    }

    override fun start() = view.start()

    override fun startAgenda() = application.startAgenda()

    override fun startGroups() = application.startGroups()

    override fun addStudent(name: String, surname: String, id: Int) {
        val student = Student(name, surname, id)
        if (model.addStudent(student))
            view.showMessage("ok")
        else
            view.showMessage("error", MessageType.ERROR)
    }

    override fun addGroup(groupName: String, vararg studentsID: Int) {
        val students = studentsID.map { model.getStudent(it) }
        if (students.none { it == null }) {
            val group = Group.createGroup(groupName, *students.map { it!! }.toTypedArray())
            if (group != null) {
                if (model.addGroup(group))
                    view.showMessage("OK")
                else
                    view.showMessage("error", MessageType.ERROR)
            } else
                view.showMessage("Error", MessageType.ERROR)
        } else
            view.showMessage("Error", MessageType.ERROR)
    }
}
