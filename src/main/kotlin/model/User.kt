package model

import java.util.Date

sealed class User(
    val name: String,
    val surname: String,
    var email: String,
    var id: Int
) {
    var course: Course? = null
    var account: Account? = null
    var agenda: Agenda? = null

    fun makeAccount(username: String, password: String) {
        account = Account(username, password.hashCode())
    }
}

class Tutor(
    name: String,
    surname: String,
    email: String,
    id: Int
): User(name, surname, email, id)

class Professor(
    name: String,
    surname: String,
    email: String,
    id: Int
): User(name, surname, email, id)
