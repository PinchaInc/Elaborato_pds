package repository.sqlite

import junit.framework.TestCase.assertNotNull
import junit.framework.TestCase.assertTrue
import model.FinalReview
import model.Group
import org.junit.Test

class TestReviewDao {
    val dao = ReviewDao()

    @Test
    fun testCreate() {
        val group = Group("group1")
        val review = FinalReview("Title", "body", 9)
        review.id = 0
        review.group = group
        assertTrue(dao.create(review))
    }

    @Test
    fun testRead() {
        val review = dao.read(Pair("group1", 0))
        assertNotNull(review)
        assertTrue(review is FinalReview)
    }

    @Test
    fun testUpdate() {
        val group = Group("group1")
        val review = FinalReview("Title", "new body", 8)
        review.id = 0
        review.group = group
        assertTrue(dao.update(review))
    }

    @Test
    fun testDelete() {
        assertTrue(dao.delete(Pair("group1", 0)))
    }
}