package repository.sqlite

import model.FinalReview
import model.Review
import repository.Dao
import java.sql.PreparedStatement
import java.sql.SQLException

class ReviewDao: Dao<Review, Pair<String, Int>> {
    override fun create(obj: Review): Boolean {
        val sql = "insert into review values (?, ?, ?, ?, ?, ?)"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setString(1, "group") // TODO
        prepStat.setInt(2, 0) // TODO
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
            e.stackTrace
            return false
        }
        return true
    }

    override fun read(id: Pair<String, Int>): Review? {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(obj: Review, oldID: Pair<String, Int>): Boolean {
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
}