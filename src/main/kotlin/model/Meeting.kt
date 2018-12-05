package model

import java.util.Date

data class Meeting(val group: Group, val start: Date, val end: Date) {
    var id: Int? = null
    var owner: User? = null
    var review: Review? = null
        set(r) {
            if (field == null && r != null) {
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
}