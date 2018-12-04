package repository

import model.Account
import model.Course
import model.Group
import model.Meeting
import model.Review
import model.Student
import model.User
import model.WorkTrack
import java.sql.PreparedStatement

abstract class Repository {
    val factory by lazy { makeDaoFactory() }

    fun readAccount(username: Int) = factory.accountDao.read(username)

    fun readCourse(username: Int): Course? {
        val courseIds = factory.courseDao.filterBy(prepareCourseStatament(username))
        if (courseIds.isEmpty())
            return null
        return factory.courseDao.read(courseIds.first())
    }

    fun saveAccount(account: Account) = factory.accountDao.create(account)

    fun saveCourse(course: Course) = factory.courseDao.create(course)

    fun saveGroup(group: Group) = factory.groupDao.create(group)

    fun saveMeeting(meeting: Meeting) = factory.meetingDao.create(
        MeetingHelper.makeMeetingHelper(meeting)!!
    )

    fun saveReview(review: Review) = factory.reviewDao.create(review)

    fun saveStudent(student: Student) = factory.studentDao.create(student)

    fun saveUser(user: User) = factory.userDao.create(user)

    fun saveWorkTrack(workTrack: WorkTrack) = factory.workTrackDao.create(workTrack)

    fun updateAccount(account: Account) = factory.accountDao.update(account)

    fun updateCourse(course: Course) = factory.courseDao.update(course)

    fun updateGroup(group: Group) = factory.groupDao.update(group)

    fun updateMeeting(meeting: Meeting) = factory.meetingDao.update(
        MeetingHelper.makeMeetingHelper(meeting)!!
    )

    fun updateReview(review: Review) = factory.reviewDao.update(review)

    fun updateStudente(student: Student) = factory.studentDao.update(student)

    fun updateUser(user: User) = factory.userDao.update(user)

    fun updateWorkTrack(workTrack: WorkTrack) = factory.workTrackDao.update(workTrack)

    fun deleteAccount(account: Account) = factory.accountDao.delete(account.username)

    fun deleteCourse(course: Course) = factory.courseDao.delete(
        Pair(course.name, course.year)
    )

    fun deleteGroup(group: Group) = factory.groupDao.delete(group.name)

    fun deleteMeeting(meeting: Meeting) = factory.meetingDao.delete(
        Pair(meeting.group.name, meeting.id!!)
    )

    fun deleteReview(review: Review) = factory.reviewDao.delete(
        Pair(review.group!!.name, review.id!!)
    )

    fun deleteStudent(student: Student) = factory.studentDao.delete(student.id)

    fun deleteUser(user: User) = factory.userDao.delete(user.id)

    fun deleteWorkTrack(workTrack: WorkTrack) = factory.workTrackDao.delete(workTrack.id!!)

    abstract fun makeDaoFactory(): DaoFactory

    abstract fun prepareCourseStatament(username: Int): PreparedStatement
}