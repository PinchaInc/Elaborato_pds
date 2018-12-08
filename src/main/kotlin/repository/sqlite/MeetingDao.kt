package repository.sqlite

import repository.Dao
import repository.MeetingHelper
import java.sql.Date
import java.sql.PreparedStatement
import java.sql.SQLException

class MeetingDao(val daoFactory: DaoFactory) : Dao<MeetingHelper, Pair<String, Int>> {
    override fun create(obj: MeetingHelper): Boolean {
        val sql = "insert into meeting values (?, ?, ?, ?, ?)"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setInt(1, obj.ownerId)
        prepStat.setString(2, obj.groupName)
        prepStat.setInt(3, obj.id)
        prepStat.setDate(4, Date(obj.start.time))
        prepStat.setDate(5, Date(obj.end.time))

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.printStackTrace()
            return false
        }
        return true
    }

    override fun read(id: Pair<String, Int>): MeetingHelper? {
        val sql = "select * from meeting where \"group\" = ? and id = ?"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setString(1, id.first)
        prepStat.setInt(2, id.second)

        val result = prepStat.executeQuery()

        if (!result.next())
            return null

        val review = daoFactory.reviewDao.read(id)

        return MeetingHelper(
            result.getDate("start"),
            result.getDate("end"),
            id.second,
            review,
            result.getInt("owner"),
            id.first
        )
    }

    override fun update(obj: MeetingHelper): Boolean {
        val sql =
            "update meeting set owner = ?, \"group\" = ?, id = ?, start = ?, end = ? where \"group\" = ? and id = ?"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setInt(1, obj.ownerId)
        prepStat.setString(2, obj.groupName)
        prepStat.setInt(3, obj.id)
        prepStat.setDate(4, Date(obj.start.time))
        prepStat.setDate(5, Date(obj.end.time))
        prepStat.setString(6, obj.groupName)
        prepStat.setInt(7, obj.id)

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.printStackTrace()
            return false
        }
        return true
    }

    override fun delete(id: Pair<String, Int>): Boolean {
        val sql = "delete from meeting where \"group\" = ? and id = ?"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setString(1, id.first)
        prepStat.setInt(2, id.second)

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.printStackTrace()
            return false
        }
        return true
    }

    override fun filterBy(stm: PreparedStatement): List<Pair<String, Int>> {
        val result = stm.executeQuery()
        val ids = ArrayList<Pair<String, Int>>()

        while (result.next())
            ids.add(Pair(result.getString("group"), result.getInt("id")))

        return ids
    }
}