package model

class Group private constructor(var name: String, val members: Array<Student>) {
    val meetings = ArrayList<Meeting>()
    var work: Work? = null
        set(work) {
            if (field == null)
                field = work
        }

    init {
        members.forEach { it.group = this }
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

    companion object {
        fun createGroup(name: String, vararg students: Student): Group? {
            return if (students.none { it.group != null })
                Group(name, students.toList().toTypedArray())
            else
                null
        }
    }
}
