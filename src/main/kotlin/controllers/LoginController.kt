package controllers

interface LoginController {
    fun setApplication(app: Application): LoginController
    fun start()
    fun authenticate(username: String, password: String)
}
