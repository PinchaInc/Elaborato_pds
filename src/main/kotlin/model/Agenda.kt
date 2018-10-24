package model

data class Agenda(val owner: User) {
    val meetings: ArrayList<Meeting> = ArrayList()

    fun addMeeting(meeting: Meeting) {
        if (!meetings.contains(meeting))
            meetings.add(meeting)
    }

    fun removeMeeting(meeting: Meeting) {
        if (meetings.contains(meeting))
            meetings.remove(meeting)
    }
}