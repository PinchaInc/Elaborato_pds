package controllers

interface StudentsController {
    fun setApplication(app: Application): StudentsController
    fun start()
    fun startAgenda()
    fun startGroups()
    fun addStudent(name: String, surname: String, id: Int)
    fun addGroup(groupName: String, vararg StudentsID: Int)
}
