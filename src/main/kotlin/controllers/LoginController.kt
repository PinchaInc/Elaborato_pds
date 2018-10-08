package controllers

interface LoginController {
    fun start()
    fun setApplication(app: Application): LoginController
    //fun authenticate(username: String, password: String) TODO
}
