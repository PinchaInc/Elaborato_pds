package model

data class Account(var username: Int, var password: Int) {

    fun passwd(oldPassword: String, newPassword: String, repeatPassword: String) {
        if (oldPassword.hashCode() == password && newPassword == repeatPassword)
            password = newPassword.hashCode()
    }

    fun authenticate(password: String): Boolean = password.hashCode() == this.password
}
