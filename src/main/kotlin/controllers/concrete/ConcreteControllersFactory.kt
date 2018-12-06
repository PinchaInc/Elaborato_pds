package controllers.concrete

import controllers.AgendaController
import controllers.Application
import controllers.ControllersFactory
import controllers.GroupsController
import controllers.LoginController
import controllers.StudentsController
import model.Model
import views.ViewsFactory

class ConcreteControllersFactory(
    private val viewsFactory: ViewsFactory,
    private val model: Model,
    private val application: Application
) : ControllersFactory {

    override fun createAgendaController(): AgendaController = ConcreteAgendaController(
        viewsFactory.createAgendaView(),
        model,
        application
    )

    override fun createGroupsController(): GroupsController = ConcreteGroupsController(
        viewsFactory.createGroupView(),
        model,
        application
    )

    override fun createLoginController(): LoginController = ConcreteLoginController(
        viewsFactory.createLoginView(),
        model,
        application
    )

    override fun createStudentsController(): StudentsController = ConcreteStudentsController(
        viewsFactory.createStudentsView(),
        model,
        application
    )
}