package model

import java.util.Date

data class Meeting(val start: Date, val end: Date, val review: Review) {
    var group: Group? = null

    init {
        review.meeting = this
    }
}