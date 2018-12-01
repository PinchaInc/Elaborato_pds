package model

class Group(var name: String, vararg students: Student) {
    var group: Group? = null
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

    fun addMeeting(meeting: Meeting) {
        if (!meetings.contains(meeting)) {
            meetings.add(meeting)
        }
    }

    fun removeMeeting(meeting: Meeting) {
        if (meetings.contains(meeting)) {
            meetings.remove(meeting)
        }
    }

    fun membersSize() = members.size

    fun meetingsSize() = meetings.size

    fun getMembers() = members.toArray()

    fun getMeetings() = meetings.toArray()

    companion object {
        fun createGroup(name: String, vararg students: Student): Group? {
            return if (students.isNotEmpty() && students.none { it.group != null })
                Group(name, *students.toList().toTypedArray())
            else null
        }
    }
}
