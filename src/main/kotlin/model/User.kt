package model


sealed class User(
    val name: String,
    val surname: String,
    var email: String,
    var id: Int
) {
    var course: Course? = null
    var account: Account? = null
    var agenda: Agenda? = null

    fun makeAccount(password: String) {
        account = Account(id, password.hashCode())
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
