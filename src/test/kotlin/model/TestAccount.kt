package model

import junit.framework.TestCase.assertEquals
import junit.framework.TestCase.assertFalse
import junit.framework.TestCase.assertTrue
import org.junit.Test

class TestAccount {

    @Test
    fun testPasswd() {
        val password = "password"
        val account = Account(1001, password.hashCode())
        val newPassword = "newPassword"
        account.passwd(password, newPassword, newPassword)

        assertEquals(newPassword.hashCode(), account.password)
    }

    @Test
    fun testPasswdErrorRepeat() {
        val password = "password"
        val account = Account(1001, password.hashCode())
        val newPassword = "newPassword"
        account.passwd(password, newPassword, "error")

        assertEquals(password.hashCode(), account.password)
    }

    @Test
    fun testPasswdErrorOldPassword() {
        val password = "password"
        val account = Account(1001, password.hashCode())
        val newPassword = "newPassword"
        account.passwd("error", newPassword, newPassword)

        assertEquals(password.hashCode(), account.password)
    }

    @Test
    fun testAuthenticate() {
        val password = "password"
        val account = Account(1001, password.hashCode())
        val auth = account.authenticate(password)
        assertTrue(auth)
    }

    @Test
    fun testAuthenticateError() {
        val password = "password"
        val account = Account(1001, password.hashCode())
        val auth = account.authenticate("error")
        assertFalse(auth)
    }
}