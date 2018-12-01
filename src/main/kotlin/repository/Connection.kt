package repository

import java.sql.Connection

interface Connection {
    fun getConnection(): Connection
}