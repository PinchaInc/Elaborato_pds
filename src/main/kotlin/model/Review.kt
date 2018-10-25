package model

open class Review(val title: String, val body: String) {
    var meeting: Meeting? = null
    var work: Work? = null
}

class FinalReview(title: String, body: String, val rating: Int): Review(title, body)
