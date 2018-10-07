package views

interface ViewsFactory {
    fun createAgendaView(): AgendaView
    fun createGroupView(): GroupsView
    fun createLoginView(): LoginView
    fun createStudentsView(): StudentsView
}