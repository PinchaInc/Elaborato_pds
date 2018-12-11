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

    fun getMeeting(meetingID: Int): Meeting? {
        return if (agenda == null)
            null
        else
            agenda!!.getMeeting(meetingID)
    }

    fun getMeetings(): Array<Meeting> {
        return agenda?.getMeetings() ?: arrayOf()
    }
}

class Tutor(
    name: String,
    surname: String,
    email: String,
    id: Int
) : User(name, surname, email, id)

class Professor(
    name: String,
    surname: String,
    email: String,
    id: Int
) : User(name, surname, email, id)
