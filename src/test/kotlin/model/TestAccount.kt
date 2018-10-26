package model

import junit.framework.TestCase.assertEquals
import org.junit.Test

class TestAccount {

    @Test
    fun testPasswd() {
        val password = "password"
        val account = Account("Username", password.hashCode())
        val newPassword = "newPassword"
        account.passwd(password, newPassword, newPassword)

        assertEquals(newPassword.hashCode(), account.password)
    }

    @Test
    fun testPasswdErrorRepeat() {
        val password = "password"
        val account = Account("Username", password.hashCode())
        val newPassword = "newPassword"
        account.passwd(password, newPassword, "error")

        assertEquals(password.hashCode(), account.password)
    }

    @Test
    fun testPasswdErrorOldPassword() {
        val password = "password"
        val account = Account("Username", password.hashCode())
        val newPassword = "newPassword"
        account.passwd("error", newPassword, newPassword)

        assertEquals(password.hashCode(), account.password)
    }
}