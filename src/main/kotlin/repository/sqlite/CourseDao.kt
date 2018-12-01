package repository.sqlite

import model.Course
import repository.Dao
import java.sql.SQLException

class CourseDao : Dao<Course, Pair<String, Int>> {
    override fun create(obj: Course): Boolean {
        val sql = "insert into course values (?, ?)"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setString(1, obj.name)
        prepStat.setInt(2, obj.year)
        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.stackTrace
            return false
        }
        return true
    }

    override fun read(id: Pair<String, Int>): Course? {
        val sql = "select * from course where name == ? and year == ? limit 1"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setString(1, id.first)
        prepStat.setInt(2, id.second)

        val result = prepStat.executeQuery()

        return if (!result.next())
            null
        else Course(result.getString(1), result.getInt(2))
    }

    override fun update(obj: Course, oldID: Pair<String, Int>): Boolean {
        val sql = "update course set name = ?, year = ? where name = ? and year = ?"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setString(1, obj.name)
        prepStat.setInt(2, obj.year)
        prepStat.setString(3, oldID.first)
        prepStat.setInt(4, oldID.second)

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.stackTrace
            return false
        }
        return true
    }

    override fun delete(id: Pair<String, Int>): Boolean {
        val sql = "delete from course where name = ? and year = ?"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setString(1, id.first)
        prepStat.setInt(2, id.second)

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.stackTrace
            return false
        }
        return true
    }
}