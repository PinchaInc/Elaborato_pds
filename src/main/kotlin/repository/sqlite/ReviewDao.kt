package repository.sqlite

import model.FinalReview
import model.Review
import repository.Dao
import java.sql.PreparedStatement
import java.sql.SQLException

class ReviewDao : Dao<Review, Pair<String, Int>> {
    override fun create(obj: Review): Boolean {
        val sql = "insert into review values (?, ?, ?, ?, ?, ?)"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        if (obj.group == null || obj.id == null)
            return false
        prepStat.setString(1, obj.group!!.name)
        prepStat.setInt(2, obj.id!!)
        prepStat.setString(3, obj.title)
        prepStat.setString(4, obj.body)
        if (obj is FinalReview) {
            prepStat.setString(5, "final")
            prepStat.setInt(6, obj.rating)
        } else {
            prepStat.setString(5, "standard")
            prepStat.setNull(6, java.sql.Types.INTEGER)
        }

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.printStackTrace()
            return false
        }
        return true
    }

    override fun read(id: Pair<String, Int>): Review? {
        val sql = "select * from review where \"group\" = ? and id = ?"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setString(1, id.first)
        prepStat.setInt(2, id.second)

        val result = prepStat.executeQuery()

        if (!result.next())
            return null
        return if (result.getString("type") == "standard")
            Review(
                result.getString("title"),
                result.getString("body")
            )
        else
            FinalReview(
                result.getString("title"),
                result.getString("body"),
                result.getInt("rating")
            )
    }

    override fun update(obj: Review, oldID: Pair<String, Int>): Boolean {
        val sql =
            "update review set \"group\" = ?, id = ?, title = ?, body = ?, type = ?, rating = ? where \"group\" = ? and id = ?"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        if (obj.group == null || obj.id == null)
            return false
        prepStat.setString(1, obj.group!!.name)
        prepStat.setInt(2, obj.id!!)
        prepStat.setString(3, obj.title)
        prepStat.setString(4, obj.body)
        if (obj is FinalReview) {
            prepStat.setString(5, "final")
            prepStat.setInt(6, obj.rating)
        } else {
            prepStat.setString(5, "standard")
            prepStat.setNull(6, java.sql.Types.INTEGER)
        }
        prepStat.setString(7, oldID.first)
        prepStat.setInt(8, oldID.second)

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.printStackTrace()
            return false
        }
        return true
    }

    override fun delete(id: Pair<String, Int>): Boolean {
        val sql = "delete from review where \"group\" = ? and id = ?"
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