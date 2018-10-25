package model

class Work(val group: Group, val workTrack: WorkTrack) {
    val reviews = ArrayList<Review>()

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
            return if (group.work == null){
                val work = Work(group, workTrack)
                group.work = work
                work
            } else null
        }
    }
}