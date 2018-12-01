package repository.sqlite

import java.sql.Connection
import java.sql.DriverManager

object Connection : repository.Connection {

    override fun getConnection(): Connection {
        val url = "jdbc:sqlite:../../../Scaricati/sync/pds.db"
        val conn = lazy {
            val conn = DriverManager.getConnection(url)
            val stm = conn.prepareStatement("PRAGMA foreign_keys = on")
            stm.execute()
            conn
        }

        return conn.value
    }
}