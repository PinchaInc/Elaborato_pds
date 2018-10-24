package model

data class Student(val name: String, val surname: String, val id: Int) {
    var group: Group? = null
    var course: Course? = null
}