package repository.sqlite

class DaoFactory : repository.DaoFactory {
    override val courseDao by lazy { CourseDao(this) }
    override val groupDao by lazy { GroupDao(this) }
    override val studentDao by lazy { StudentDao() }
    override val userDao by lazy { UserDao() }
}