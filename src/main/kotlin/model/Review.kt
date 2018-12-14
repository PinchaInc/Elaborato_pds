package model

open class Review(val title: String, val body: String) {
    var id: Int? = null
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

class FinalReview(title: String, body: String, val rating: Int) : Review(title, body) {
    companion object {
        fun makeFinalReview(title: String, body: String, rating: Int): FinalReview? {
            return if (rating in 1..30)
                FinalReview(title, body, rating)
            else
                null
        }
    }
}
