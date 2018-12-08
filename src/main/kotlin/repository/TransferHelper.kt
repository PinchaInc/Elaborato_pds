package repository

import model.Group
import model.Meeting
import model.Review
import java.util.Date

data class MeetingHelper(
    val start: Date,
    val end: Date,
    val id: Int,
    val review: Review?,
    val ownerId: Int,
    val groupName: String
) {

    fun makeMeeting(group: Group): Meeting {
        val meeting = Meeting(group, start, end)
        if (review != null)
            meeting.review = review
        meeting.id = id

        return meeting
    }

    companion object {
        fun makeMeetingHelper(meeting: Meeting): MeetingHelper? {
            return if (meeting.id == null || meeting.owner == null)
                null
            else MeetingHelper(
                meeting.start,
                meeting.end,
                meeting.id!!,
                meeting.review,
                meeting.owner!!.id,
                meeting.group.name
            )
        }
    }
}