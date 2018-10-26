package model

open class Review(val title: String, val body: String) {
    var meeting: Meeting? = null
        set(m) {
            if (field == null) {
                field = m
                m?.review = this
            }
        }
    var work: Work? = null
}

class FinalReview(title: String, body: String, val rating: Int) : Review(title, body)
