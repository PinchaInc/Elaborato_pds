package controllers

import model.Model
import views.ViewsFactory

abstract class Application {
    var loginController: Lazy<LoginController>? = null
    var studentsController: Lazy<StudentsController>? = null
    var agendaController: Lazy<AgendaController>? = null
    var groupsController: Lazy<GroupsController>? = null
    val isLogged: Boolean = TODO()

    fun start() {
        val controllersFactory = makeControllersFactory(
            makeViewsFactory(),
            makeModel()
        )

        loginController = lazy {
            controllersFactory.createLoginController()
                .setApplication(this)
        }
        studentsController = lazy {
            controllersFactory.createStudentsController()
                .setApplication(this)
        }
        agendaController = lazy {
            controllersFactory.createAgendaController()
                .setApplication(this)
        }
        groupsController = lazy {
            controllersFactory.createGroupsController()
                .setApplication(this)
        }

        if (isLogged)
            startStudents()
        else
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

    protected open fun makeControllersFactory(viewsFactory: ViewsFactory, model: Model): ControllersFactory {
        TODO()
    }

    protected open fun makeModel(): Model {
        TODO()
    }

    protected abstract fun makeViewsFactory(): ViewsFactory
}
