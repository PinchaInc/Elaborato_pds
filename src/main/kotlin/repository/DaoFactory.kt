package repository

import model.Account
import model.Course
import model.Group
import model.Review
import model.Student
import model.User
import model.WorkTrack

interface DaoFactory {
    val accountDao: Dao<Account, Int>
    val courseDao: Dao<Course, Pair<String, Int>>
    val groupDao: Dao<Group, String>
    val meetingDao: Dao<MeetingHelper, Pair<String, Int>>
    val reviewDao: Dao<Review, Pair<String, Int>>
    val studentDao: Dao<Student, Int>
    val userDao: Dao<User, Int>
    val workTrackDao: Dao<WorkTrack, Int>
}