package repository.sqlite

class DaoFactory : repository.DaoFactory {
    override val accountDao by lazy { AccountDao() }
    override val courseDao by lazy { CourseDao(this) }
    override val groupDao by lazy { GroupDao(this) }
    override val meetingDao by lazy { MeetingDao(this) }
    override val reviewDao by lazy { ReviewDao() }
    override val studentDao by lazy { StudentDao() }
    override val userDao by lazy { UserDao() }
    override val workTrackDao by lazy { WorkTrackDao() }
}