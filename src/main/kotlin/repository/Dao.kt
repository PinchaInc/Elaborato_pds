package repository

interface Dao<T, ID> {
    fun create(obj: T): Boolean
    fun read(id: ID): T?
    fun update(obj: T, oldID: ID): Boolean
    fun delete(id: ID): Boolean
}