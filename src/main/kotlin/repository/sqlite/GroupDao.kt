package repository.sqlite

import model.Group
import model.Student
import repository.Dao
import java.sql.PreparedStatement
import java.sql.SQLException

class GroupDao(val daoFactory: DaoFactory) : Dao<Group, String> {
    override fun create(obj: Group): Boolean {
        val sql = "insert into \"group\" values (?, ?, ?)"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setString(1, obj.name)
        if (obj.course == null) {
            prepStat.setNull(2, java.sql.Types.VARCHAR)
            prepStat.setNull(3, java.sql.Types.INTEGER)
        } else {
            prepStat.setString(2, obj.course!!.name)
            prepStat.setInt(3, obj.course!!.year)
        }

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.stackTrace
            return false
        }
        return true
    }

    override fun read(id: String): Group? {
        val sql = "select name from \"group\" where name=? limit 1"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setString(1, id)

        val result = prepStat.executeQuery()

        if (!result.next())
            return null

        val groupName = result.getString("name")

        val members = ArrayList<Student>()
        val studentDao = daoFactory.studentDao
        studentDao.filterBy(prepareStudentStatament(groupName))
            .map { studentDao.read(it) }
            .forEach {
                if (it != null)
                    members.add(it)
            }

        return Group(groupName, *members.toTypedArray())
    }

    override fun update(obj: Group, oldID: String): Boolean {
        val sql = "update \"group\" set name = ?, course_name = ?, course_year = ? where name = ?"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setString(1, obj.name)
        if (obj.course == null) {
            prepStat.setNull(2, java.sql.Types.VARCHAR)
            prepStat.setNull(3, java.sql.Types.INTEGER)
        } else {
            prepStat.setString(2, obj.course!!.name)
            prepStat.setInt(3, obj.course!!.year)
        }
        prepStat.setString(4, oldID)

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.stackTrace
            return false
        }
        return true
    }

    override fun delete(id: String): Boolean {
        val sql = "delete from \"group\" where name = ?"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setString(1, id)

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.stackTrace
            return false
        }
        return true
    }

    override fun filterBy(stm: PreparedStatement): List<String> {
        val result = stm.executeQuery()
        val ids = ArrayList<String>()

        while (result.next())
            ids.add(result.getString(1))

        return ids
    }

    private fun prepareStudentStatament(groupName: String): PreparedStatement {
        val sql = "select id from student where \"group\" = ?"
        val stm = Connection.getConnection().prepareStatement(sql)
        stm.setString(1, groupName)
        return stm
    }
}