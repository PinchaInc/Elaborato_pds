package model

class Work private constructor(val group: Group, val workTrack: WorkTrack) {
    val reviews = ArrayList<Review>()

    init {
        group.work = this
    }

    fun addReview(review: Review){
        if (!reviews.contains(review)) {
            reviews.add(review)
            review.work = this
        }
    }

    fun removeReview(review: Review){
        if (reviews.contains(review)) {
            reviews.remove(review)
            review.work = null
        }
    }

    companion object {
        fun createWork(group: Group, workTrack: WorkTrack): Work? {
            return if (group.work == null)
                Work(group, workTrack)
            else
                null
        }
    }
}