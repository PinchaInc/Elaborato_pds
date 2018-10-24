package model

import java.time.Year

class Course(val name: String, val year: Year) {
    val students = ArrayList<Student>()
    val professors = ArrayList<Professor>()
    val tutors = ArrayList<Tutor>()
    val workTracks = ArrayList<WorkTrack>()
    val groups = ArrayList<Group>()

    fun addStudent(student: Student) {
        if (student.course == null && !students.contains(student)) {
            students.add(student)
            student.course = this
        }
    }

    fun removeStudent(student: Student) {
        if (students.contains(student)) {
            students.remove(student)
            student.course = null
        }
    }

    fun addGroup(group: Group) {
        if (!groups.contains(group))
            groups.add(group)
    }

    fun removeGroup(group: Group) {
        if (groups.contains(group))
            groups.remove(group)
    }

    fun addWorkTrack(workTrack: WorkTrack) {
        if (!workTracks.contains(workTrack))
            workTracks.add(workTrack)
    }

    fun removeWorkTrack(workTrack: WorkTrack) {
        if (workTracks.contains(workTrack))
            workTracks.remove(workTrack)
    }

    fun addTeacher(teacher: User) {
        when (teacher) {
            is Professor -> {
                if (!professors.contains(teacher))
                    professors.add(teacher)
            }
            else -> {
                if (!tutors.contains(teacher))
                    tutors.add(teacher as Tutor)
            }
        }
    }

    fun removeTeacher(teacher: User) {
        when (teacher) {
            is Professor -> {
                if (professors.contains(teacher))
                    professors.remove(teacher)
            }
            else -> {
                if (tutors.contains(teacher))
                    tutors.remove(teacher as Tutor)
            }
        }
    }
}