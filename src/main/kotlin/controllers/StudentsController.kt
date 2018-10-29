package controllers

interface StudentsController {
    fun start()
    fun startAgenda()
    fun startGroups()
    fun addStudent(name: String, surname: String, id: Int)
    fun addGroup(groupName: String, vararg studentsID: Int)
}
