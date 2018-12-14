package model

import java.util.Date

data class Meeting(val group: Group, val start: Date, val end: Date) {
    var id: Int? = null
    var owner: User? = null
    var review: Review? = null
        set(r) {
            if (r != null) {
                field = r
                r.meeting = this
                r.group = group
                group.work?.addReview(r)
            }
        }

    init {
        if (group.addMeeting(this))
            id = group.increaseMeeting()
    }

    companion object {
        fun makeMeeting(group: Group, start: Date): Meeting? {
            return if (start.before(Date()))
                null
            else
                Meeting(group, start, start)
        }
    }
}