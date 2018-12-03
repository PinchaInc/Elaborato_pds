package model

data class WorkTrack(val title: String, val body: String) {
    var course: Course? = null
    var id: Int? = null
}
