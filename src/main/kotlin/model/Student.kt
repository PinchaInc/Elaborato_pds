package model

data class Student(val name: String, val surname: String, val id: Int) {
    var group: Group? = null
        set(g) {
            if (field == null)
                field = g
        }
    var course: Course? = null
        set(c) {
            if (field != c) {
                field?.removeStudent(this)
                field = c
                field?.addStudent(this)
            }
        }
}