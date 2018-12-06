package views.swing

import views.AgendaView
import views.GroupsView
import views.LoginView
import views.StudentsView
import views.ViewsFactory

class SwingFactory: ViewsFactory {
    override fun createAgendaView(): AgendaView = AgendaSwing()

    override fun createGroupView(): GroupsView = GroupsSwing()

    override fun createLoginView(): LoginView = Login()

    override fun createStudentsView(): StudentsView = Students()
}