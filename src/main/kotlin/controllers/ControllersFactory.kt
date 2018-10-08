package controllers

interface ControllersFactory {
    fun createAgendaController(): AgendaController
    fun createGroupsController(): GroupsController
    fun createLoginController(): LoginController
    fun createStudentsController(): StudentsController
}