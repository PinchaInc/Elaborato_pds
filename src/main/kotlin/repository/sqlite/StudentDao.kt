package repository.sqlite

import model.Student
import repository.Dao
import java.sql.SQLException

class StudentDao : Dao<Student, Int> {
    override fun create(obj: Student): Boolean {
        val sql = "insert into student values (?, ?, ?, ?, ?, ?)"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setInt(1, obj.id)
        prepStat.setString(2, obj.name)
        prepStat.setString(3, obj.surname)
        if (obj.group == null)
            prepStat.setNull(4, java.sql.Types.VARCHAR)
        else
            prepStat.setString(4, obj.group!!.name)
        if (obj.course == null) {
            prepStat.setNull(5, java.sql.Types.VARCHAR)
            prepStat.setNull(6, java.sql.Types.INTEGER)
        } else {
            prepStat.setString(5, obj.course!!.name)
            prepStat.setInt(6, obj.course!!.year)
        }

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.stackTrace
            return false
        }
        return true
    }

    override fun read(id: Int): Student? {
        val sql = "select id, name, surname from student where id = ? limit 1"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setInt(1, id)

        val result = prepStat.executeQuery()

        return if (!result.next())
            null
        else
            Student(
                result.getString("name"),
                result.getString("surname"),
                result.getInt("id")
            )
    }

    override fun update(obj: Student, oldID: Int): Boolean {
        val sql =
            "update student set id = ?, name = ?, surname = ?, \"group\" = ? ,course_name = ?, course_year = ? where id = ?"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setInt(1, obj.id)
        prepStat.setString(2, obj.name)
        prepStat.setString(3, obj.surname)
        if (obj.group == null)
            prepStat.setNull(4, java.sql.Types.VARCHAR)
        else
            prepStat.setString(4, obj.group!!.name)
        if (obj.course == null) {
            prepStat.setNull(5, java.sql.Types.VARCHAR)
            prepStat.setNull(6, java.sql.Types.INTEGER)
        } else {
            prepStat.setString(5, obj.course!!.name)
            prepStat.setInt(6, obj.course!!.year)
        }
        prepStat.setInt(7, oldID)

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.stackTrace
            return false
        }
        return true
    }

    override fun delete(id: Int): Boolean {
        val sql = "delete from student where id = ?"
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