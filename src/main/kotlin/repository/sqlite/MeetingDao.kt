package repository.sqlite

import model.Meeting
import repository.Dao
import java.sql.PreparedStatement
import java.sql.SQLException

class MeetingDao: Dao<Meeting, Pair<String, Int>> {
    override fun create(obj: Meeting): Boolean {
        val sql = "insert into meeting values (?, ?, ?, ?, ?)"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setInt(1, 1) // TODO
        prepStat.setString(2, obj.group.name)
        prepStat.setInt(3, 0) // TODO
        prepStat.setString(4, obj.start.toString())
        prepStat.setString(5, obj.end.toString())

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.stackTrace
            return false
        }
        return true
    }

    override fun read(id: Pair<String, Int>): Meeting? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(obj: Meeting, oldID: Pair<String, Int>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(id: Pair<String, Int>): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun filterBy(stm: PreparedStatement): List<Pair<String, Int>> {
        val result = stm.executeQuery()
        val ids = ArrayList<Pair<String, Int>>()

        while (result.next())
            ids.add(Pair(result.getString("group"), result.getInt("id")))

        return ids
    }

    private fun prepareReviewStatament(group: String, id: Int): PreparedStatement {
        TODO()
    }
}