package controllers

interface LoginController {
    fun start()
    fun authenticate(username: String, password: String)
}
