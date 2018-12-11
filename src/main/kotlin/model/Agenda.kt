package model

data class Agenda(val owner: User) {

    init {
        owner.agenda = this
    }

    private val meetings: ArrayList<Meeting> = ArrayList()

    fun addMeeting(meeting: Meeting): Boolean {
        if (meetings.none { it.id == meeting.id && it.group.name == meeting.group.name }) {
            meetings.add(meeting)
            meeting.owner = owner
            meetings.sortBy { it.start }
            return true
        }
        return false
    }

    fun removeMeeting(meeting: Meeting) {
        if (meetings.contains(meeting))
            meetings.remove(meeting)
    }

    fun meetingSize() = meetings.size

    fun getMeetings() = meetings.toTypedArray()

    fun getMeeting(meetingID: Int): Meeting? {
        return if (meetings.size > meetingID)
            meetings[meetingID]
        else null
    }
}