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
        if (!meetings.contains(meeting) && meetingCount < 4) {
            meetings.add(meeting)
            return true
        } else
            return false
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

    companion object {
        fun createGroup(name: String, vararg students: Student): Group? {
            return if (students.isNotEmpty() && students.none { it.group != null })
                Group(name, *students.toList().toTypedArray())
            else null
        }
    }
}
