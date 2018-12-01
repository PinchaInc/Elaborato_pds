package repository.sqlite

import model.Professor
import model.Tutor
import model.User
import repository.Dao
import java.sql.SQLException
import java.util.Date

class UserDao : Dao<User, Int> {
    override fun create(obj: User): Boolean {
        val sql = "insert into user values (?, ?, ?, ?, ?, ?, ?, ?)"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setInt(1, obj.id)
        prepStat.setString(2, obj.name)
        prepStat.setString(3, obj.surname)
        prepStat.setString(4, obj.birthDate.toString()) // TODO
        prepStat.setString(5, obj.email)
        prepStat.setString(6, if (obj is Professor) "professor" else "tutor")
        if (obj.course == null) {
            prepStat.setNull(7, java.sql.Types.VARCHAR)
            prepStat.setNull(8, java.sql.Types.INTEGER)
        } else {
            prepStat.setString(7, obj.course!!.name)
            prepStat.setInt(8, obj.course!!.year)
        }

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.stackTrace
            return false
        }
        return true
    }

    override fun read(id: Int): User? {
        val sql = "select * from user where id = ? limit 1"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setInt(1, id)

        val result = prepStat.executeQuery()

        return if (!result.next())
            null
        else
            if (result.getString("type") == "professor")
                Professor(
                    result.getString("name"),
                    result.getString("surname"),
                    Date(), // TODO
                    result.getString("email"),
                    result.getInt("id")
                )
            else
                Tutor(
                    result.getString("name"),
                    result.getString("surname"),
                    Date(), // TODO
                    result.getString("email"),
                    result.getInt("id")
                )
    }

    override fun update(obj: User, oldID: Int): Boolean {
        val sql =
            "update user set id = ?, name = ?, surname = ?, birthDate = ?, email = ?, course_name = ?, course_year = ? where id=?"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setInt(1, obj.id)
        prepStat.setString(2, obj.name)
        prepStat.setString(3, obj.surname)
        prepStat.setString(4, obj.birthDate.toString()) // TODO
        prepStat.setString(5, obj.email)
        if (obj.course == null) {
            prepStat.setNull(6, java.sql.Types.VARCHAR)
            prepStat.setNull(7, java.sql.Types.INTEGER)
        } else {
            prepStat.setString(6, obj.course!!.name)
            prepStat.setInt(7, obj.course!!.year)
        }
        prepStat.setInt(8, oldID)

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.stackTrace
            return false
        }
        return true
    }

    override fun delete(id: Int): Boolean {
        val sql = "delete from user where id == ?"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setInt(1, id)

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.stackTrace
            return false
        }
        return true
    }
}