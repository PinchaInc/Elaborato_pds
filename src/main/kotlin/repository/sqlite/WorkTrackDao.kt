package repository.sqlite

import model.WorkTrack
import repository.Dao
import java.sql.PreparedStatement
import java.sql.SQLException

class WorkTrackDao : Dao<WorkTrack, Int> {
    override fun create(obj: WorkTrack): Boolean {
        val sql = "insert into workTrack values (?, ?, ?, ?, ?)"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        if (obj.id == null)
            return false
        prepStat.setInt(1, obj.id!!)
        prepStat.setString(2, obj.title)
        prepStat.setString(3, obj.body)
        if (obj.course == null) {
            prepStat.setNull(4, java.sql.Types.VARCHAR)
            prepStat.setNull(5, java.sql.Types.INTEGER)
        } else {
            prepStat.setString(4, obj.course!!.name)
            prepStat.setInt(5, obj.course!!.year)
        }

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.printStackTrace()
            return false
        }
        return true
    }

    override fun read(id: Int): WorkTrack? {
        val sql = "select title, body, id from workTrack where id = ?"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setInt(1, id)

        val result = prepStat.executeQuery()

        if (!result.next())
            return null

        val workTrack = WorkTrack(result.getString("title"), result.getString("body"))

        val id = result.getInt("id")
        if (id != 0)
            workTrack.id = id

        return workTrack
    }

    override fun update(obj: WorkTrack): Boolean {
        val sql = "update workTrack set id = ?, title = ?, body = ?, course_name = ?, course_year = ? where id = ?"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        if (obj.id == null)
            return false
        prepStat.setInt(1, obj.id!!)
        prepStat.setString(2, obj.title)
        prepStat.setString(3, obj.body)
        if (obj.course == null) {
            prepStat.setNull(4, java.sql.Types.VARCHAR)
            prepStat.setNull(5, java.sql.Types.INTEGER)
        } else {
            prepStat.setString(4, obj.course!!.name)
            prepStat.setInt(5, obj.course!!.year)
        }
        prepStat.setInt(6, obj.id!!)

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.printStackTrace()
            return false
        }
        return true
    }

    override fun delete(id: Int): Boolean {
        val sql = "delete from workTrack where id = ?"
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
            ids.add(result.getInt(1))

        return ids
    }
}