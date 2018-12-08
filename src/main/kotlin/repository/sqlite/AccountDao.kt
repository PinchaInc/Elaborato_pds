package repository.sqlite

import model.Account
import repository.Dao
import java.sql.PreparedStatement
import java.sql.SQLException

class AccountDao: Dao<Account, Int> {
    override fun create(obj: Account): Boolean {
        val sql = "insert into account values (?, ?)"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setInt(1, obj.username)
        prepStat.setInt(2, obj.password)

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.printStackTrace()
            return false
        }
        return true
    }

    override fun read(id: Int): Account? {
        val sql = "select * from account where id = ?"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setInt(1, id)

        val result = prepStat.executeQuery()

        if (!result.next())
            return null

        return Account(result.getInt("id"), result.getInt("password"))
    }

    override fun update(obj: Account): Boolean {
        val sql = "update account set password = ? where id = ?"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setInt(1, obj.password)
        prepStat.setInt(2, obj.username)

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.printStackTrace()
            return false
        }
        return true
    }

    override fun delete(id: Int): Boolean {
        val sql = "delete from account where id = ?"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setInt(1, id)

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.printStackTrace()
            return false
        }
        return true
    }

    override fun filterBy(stm: PreparedStatement): List<Int> {
        val result = stm.executeQuery()
        val ids = ArrayList<Int>()

        while (result.next())
            ids.add(result.getInt("id"))

        return ids
    }
}