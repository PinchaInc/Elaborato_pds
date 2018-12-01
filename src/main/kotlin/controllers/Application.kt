package controllers

import controllers.concrete.ConcreteControllersFactory
import model.Model
import views.ViewsFactory

abstract class Application {
    val factory by lazy {
        makeControllersFactory(
            makeViewsFactory(),
            makeModel(),
            this
        )
    }
    val loginController by lazy { factory.createLoginController() }
    val studentsController by lazy { factory.createStudentsController() }
    val agendaController by lazy { factory.createAgendaController() }
    val groupsController by lazy { factory.createGroupsController() }

    fun start() = startLogin()

    fun startLogin() = loginController.start()

    fun startStudents() = studentsController.start()

    fun startAgenda() = agendaController.start()

    fun startGroups() = groupsController.start()

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
