package model

import java.util.Date

data class Meeting(val group: Group, val start: Date, val end: Date) {
    var review: Review? = null
        set(r) {
            field = r
            field?.meeting = this
        }

    init {
        group.addMeeting(this)
    }
}