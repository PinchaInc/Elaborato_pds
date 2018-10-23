package ui

import controllers.AgendaController
import controllers.Application
import controllers.StudentsController
import views.swing.AgendaSwing
import views.swing.StudentsSwing

class ApplicationStub(
    val agendaController: AgendaController,
    val studentsController: StudentsController
) {
    fun startStudents() = studentsController.start()

    fun startAgenda() = agendaController.start()
}

class AgendaControllerStub: AgendaController {
    var app: ApplicationStub? = null
    val view = AgendaSwing()

    init {
        view.setController(this)
    }

    override fun start() = view.start()

    override fun setApplication(app: Application): AgendaController {
        TODO()
    }

    override fun startStudents() {
        app?.startStudents()
    }

    override fun startGroups() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

class StudentsControllerStub: StudentsController {

    var app: ApplicationStub? = null
    val view = StudentsSwing()

    init {
        view.setController(this)
    }

    override fun start() = view.start()

    override fun setApplication(app: Application): StudentsController {
        TODO()
    }

    override fun startGroups() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun startAgenda() {
        app?.startAgenda()
    }
}


fun main(args: Array<String>) {
    val ac = AgendaControllerStub()
    val sc = StudentsControllerStub()
    val app = ApplicationStub(ac, sc)
    ac.app = app
    sc.app = app

    ac.start()
}