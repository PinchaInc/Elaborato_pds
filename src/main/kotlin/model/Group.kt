package model

class Group(var name: String, vararg students: Student) {
    private var meetingCount = 0
    var course: Course? = null
    private val members = ArrayList<Student>()
    private val meetings = ArrayList<Meeting>()
    var work: Work? = null
        set(work) {
            if (field == null)
                field = work
        }

    init {
        students.forEach {
            it.group = this
            members.add(it)
        }
    }

    fun addMeeting(meeting: Meeting): Boolean {
        return if (meetings.none { it.id == meeting.id && it.group.name == meeting.group.name }
            && meetingCount < 5) {
            meetings.add(meeting)
            true
        } else
            false
    }

    fun removeMeeting(meeting: Meeting) {
        if (meetings.contains(meeting)) {
            meetings.remove(meeting)
        }
    }

    fun membersSize() = members.size

    fun meetingsSize() = meetings.size

    fun getMembers() = members.toTypedArray()

    fun getMeetings() = meetings.toTypedArray()

    fun increaseMeeting(): Int {
        meetingCount++
        return meetingCount
    }

    fun clear() {
        members.forEach { it.group = null }
    }

    companion object {
        fun createGroup(name: String, vararg students: Student): Group? {
            return if (students.isNotEmpty() && students.none { it.group != null })
                Group(name, *students.toList().toTypedArray())
            else null
        }
    }
}
