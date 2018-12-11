package repository.sqlite

import model.Group
import model.Student
import model.Work
import repository.Dao
import java.sql.PreparedStatement
import java.sql.SQLException

class GroupDao(val daoFactory: DaoFactory) : Dao<Group, String> {
    override fun create(obj: Group): Boolean {
        val sql = "insert into \"group\" values (?, ?, ?, ?)"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setString(1, obj.name)
        if (obj.course == null) {
            prepStat.setNull(2, java.sql.Types.VARCHAR)
            prepStat.setNull(3, java.sql.Types.INTEGER)
        } else {
            prepStat.setString(2, obj.course!!.name)
            prepStat.setInt(3, obj.course!!.year)
        }
        if (obj.work == null || obj.work!!.workTrack.id == null)
            prepStat.setNull(4, java.sql.Types.INTEGER)
        else
            prepStat.setInt(4, obj.work!!.workTrack.id!!)

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.printStackTrace()
            return false
        }
        return true
    }

    override fun read(id: String): Group? {
        val sql = "select name, work_track from \"group\" where name=? limit 1"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setString(1, id)

        val result = prepStat.executeQuery()

        if (!result.next())
            return null

        val groupName = result.getString("name")
        val workTrackID = result.getInt("work_track")

        val members = ArrayList<Student>()
        val studentDao = daoFactory.studentDao
        studentDao.filterBy(prepareStudentStatament(groupName))
            .map { studentDao.read(it) }
            .forEach {
                if (it != null)
                    members.add(it)
            }

        val group = Group(groupName, *members.toTypedArray())

        val workTrack = if (workTrackID != 0) daoFactory.workTrackDao.read(workTrackID) else null
        if (workTrack != null)
            Work.createWork(group, workTrack)

        return group
    }

    override fun update(obj: Group): Boolean {
        val sql = "update \"group\" set name = ?, course_name = ?, course_year = ?, work_track = ? where name = ?"
        val prepStat = Connection.getConnection().prepareStatement(sql)
        prepStat.setString(1, obj.name)
        if (obj.course == null) {
            prepStat.setNull(2, java.sql.Types.VARCHAR)
            prepStat.setNull(3, java.sql.Types.INTEGER)
        } else {
            prepStat.setString(2, obj.course!!.name)
            prepStat.setInt(3, obj.course!!.year)
        }
        if (obj.work == null || obj.work!!.workTrack.id == null)
            prepStat.setNull(4, java.sql.Types.INTEGER)
        else
            prepStat.setInt(4, obj.work!!.workTrack.id!!)
        prepStat.setString(5, obj.name)

        try {
            prepStat.execute()
        } catch (e: SQLException) {
            e.printStackTrace()
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
            e.printStackTrace()
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