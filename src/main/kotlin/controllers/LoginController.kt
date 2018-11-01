package controllers

interface LoginController {
    fun start()
    fun startAgenda()
    fun startGroups()
    fun startStudents()
    fun authenticate(username: String, password: String)
}
