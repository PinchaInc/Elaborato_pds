package repository.sqlite

import java.sql.Connection
import java.sql.DriverManager

object Connection : repository.Connection {
    private val url = "jdbc:sqlite:../../../Scaricati/sync/pds.db"
    private var conn: Connection

    init {
        conn = setConnection()
    }

    fun setConnection(): Connection {
        val conn = DriverManager.getConnection(url)
        val stm = conn.prepareStatement("PRAGMA foreign_keys = on")
        stm.execute()
        return conn
    }

    override fun getConnection(): Connection {
        if (conn.isClosed)
            conn = setConnection()
        return conn
    }
}