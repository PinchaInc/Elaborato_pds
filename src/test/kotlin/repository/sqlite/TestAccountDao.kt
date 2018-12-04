package repository.sqlite

import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import model.Account
import org.junit.Test

class TestAccountDao {
    val dao = AccountDao()

    @Test
    fun testCreate() {
        assertTrue(dao.create(Account(101, "password".hashCode())))
    }

    @Test
    fun testRead() {
        assertNotNull(dao.read(101))
    }

    @Test
    fun testUpdate() {
        assertTrue(dao.update(Account(101, "new password".hashCode())))
    }

    @Test
    fun testDelete() {
        assertTrue(dao.delete(101))
    }
}