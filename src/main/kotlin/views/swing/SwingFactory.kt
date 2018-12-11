package views.swing

import views.AgendaView
import views.GroupsView
import views.LoginView
import views.StudentsView
import views.ViewsFactory

class SwingFactory: ViewsFactory {
    override fun createAgendaView(): AgendaView = AgendaView()

    override fun createGroupView(): GroupsView = GroupsView()

    override fun createLoginView(): LoginView = LoginView()

    override fun createStudentsView(): StudentsView = StudentsView()
}