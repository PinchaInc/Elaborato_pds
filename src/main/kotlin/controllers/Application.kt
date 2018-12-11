package controllers

import controllers.concrete.ConcreteControllersFactory
import model.ConcreteModel
import model.Model
import repository.DaoFactory
import repository.Repository
import repository.sqlite.Connection
import views.ViewsFactory
import java.sql.PreparedStatement

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
        return object : ConcreteModel() {
            override fun makeRepository(): Repository {
                return object : Repository() {
                    override fun makeDaoFactory(): DaoFactory {
                        return repository.sqlite.DaoFactory()
                    }

                    override fun prepareCourseStatament(username: Int): PreparedStatement {
                        val sql = "select course_name, course_year from user where id = ?"
                        val stm = Connection.getConnection().prepareStatement(sql)
                        stm.setInt(1, username)
                        return stm
                    }
                }
            }
        }
    }

    protected abstract fun makeViewsFactory(): ViewsFactory
}
