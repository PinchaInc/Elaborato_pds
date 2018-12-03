package model

open class Review(val title: String, val body: String) {
    private var id: Int? = null
    var group: Group? = null
    var meeting: Meeting? = null
        set(m) {
            if (field == null) {
                field = m
                m?.review = this
                id = m?.id
            }
        }
    var work: Work? = null
}

class FinalReview(title: String, body: String, val rating: Int) : Review(title, body)
