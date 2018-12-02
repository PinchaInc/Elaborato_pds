package repository

import model.Course
import model.Group
import model.Student
import model.User

interface DaoFactory {
    val courseDao: Dao<Course, Pair<String, Int>>
    val groupDao: Dao<Group, String>
    val studentDao: Dao<Student, Int>
    val userDao: Dao<User, Int>
}