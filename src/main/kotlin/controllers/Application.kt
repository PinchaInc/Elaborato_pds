package controllers

import controllers.concrete.ConcreteControllersFactory
import model.Model
import views.ViewsFactory

abstract class Application {
    var loginController: Lazy<LoginController>? = null
    var studentsController: Lazy<StudentsController>? = null
    var agendaController: Lazy<AgendaController>? = null
    var groupsController: Lazy<GroupsController>? = null

    fun start() {
        val controllersFactory = makeControllersFactory(
            makeViewsFactory(),
            makeModel(),
            this
        )

        loginController = lazy {
            controllersFactory.createLoginController()
        }
        studentsController = lazy {
            controllersFactory.createStudentsController()
        }
        agendaController = lazy {
            controllersFactory.createAgendaController()
        }
        groupsController = lazy {
            controllersFactory.createGroupsController()
        }

        startLogin()
    }

    fun startLogin() {
        loginController?.value?.start()
    }

    fun startStudents() {
        studentsController?.value?.start()
    }

    fun startAgenda() {
        agendaController?.value?.start()
    }

    fun startGroups() {
        groupsController?.value?.start()
    }

    protected open fun makeControllersFactory(
        viewsFactory: ViewsFactory,
        model: Model,
        application: Application
    ): ControllersFactory = ConcreteControllersFactory(
        viewsFactory,
        model,
        application
    )

    protected open fun makeModel(): Model {
        TODO()
    }

    protected abstract fun makeViewsFactory(): ViewsFactory
}
