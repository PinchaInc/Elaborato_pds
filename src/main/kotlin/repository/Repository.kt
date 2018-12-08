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
        return if (courseIds.isEmpty())
            null
        else
            factory.courseDao.read(courseIds.first())
    }

    fun saveAccount(account: Account) = factory.accountDao.create(account)

    fun saveCourse(course: Course) = factory.courseDao.create(course)

    fun saveGroup(group: Group): Boolean {
        if (!factory.groupDao.create(group))
            return false
        return group.getMembers().map { factory.studentDao.update(it) }.none { !it }
    }

    fun saveMeeting(meeting: Meeting): Boolean {
        val meetingHelper = MeetingHelper.makeMeetingHelper(meeting)
        return if (meetingHelper == null)
            false
        else
            factory.meetingDao.create(meetingHelper)
    }

    fun saveReview(review: Review) = factory.reviewDao.create(review)

    fun saveStudent(student: Student) = factory.studentDao.create(student)

    fun saveUser(user: User) = factory.userDao.create(user)

    fun saveWorkTrack(workTrack: WorkTrack) = factory.workTrackDao.create(workTrack)

    fun updateAccount(account: Account) = factory.accountDao.update(account)

    fun updateCourse(course: Course) = factory.courseDao.update(course)

    fun updateGroup(group: Group) = factory.groupDao.update(group)

    fun updateMeeting(meeting: Meeting): Boolean {
        val meetingHelper = MeetingHelper.makeMeetingHelper(meeting)
        return if (meetingHelper == null)
            false
        else
            factory.meetingDao.update(meetingHelper)
    }

    fun updateReview(review: Review) = factory.reviewDao.update(review)

    fun updateStudente(student: Student) = factory.studentDao.update(student)

    fun updateUser(user: User) = factory.userDao.update(user)

    fun updateWorkTrack(workTrack: WorkTrack) = factory.workTrackDao.update(workTrack)

    fun deleteAccount(account: Account) = factory.accountDao.delete(account.username)

    fun deleteCourse(course: Course) = factory.courseDao.delete(
        Pair(course.name, course.year)
    )

    fun deleteGroup(group: Group) = factory.groupDao.delete(group.name)

    fun deleteMeeting(meeting: Meeting): Boolean {
        return if (meeting.id == null)
            false
        else
            factory.meetingDao.delete(
                Pair(meeting.group.name, meeting.id!!)
            )
    }

    fun deleteReview(review: Review): Boolean {
        return if (review.group == null || review.id == null)
            false
        else
            factory.reviewDao.delete(
                Pair(review.group!!.name, review.id!!)
            )
    }

    fun deleteStudent(student: Student) = factory.studentDao.delete(student.id)

    fun deleteUser(user: User) = factory.userDao.delete(user.id)

    fun deleteWorkTrack(workTrack: WorkTrack): Boolean {
        return if (workTrack.id == null)
            false
        else
            factory.workTrackDao.delete(workTrack.id!!)
    }

    abstract fun makeDaoFactory(): DaoFactory

    abstract fun prepareCourseStatament(username: Int): PreparedStatement
}