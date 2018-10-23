package controllers

interface StudentsController {
    fun start()
    fun setApplication(app: Application): StudentsController
    fun startAgenda()
    fun startGroups()
    //fun addStudent(name: String, id: Int) TODO
    //fun addGroup(groupName: String, vararg ids: Int) TODO
}
