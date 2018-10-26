package model

class Course(val name: String, val year: Int) {
    private val students = ArrayList<Student>()
    private val professors = ArrayList<Professor>()
    private val tutors = ArrayList<Tutor>()
    private val workTracks = ArrayList<WorkTrack>()
    private val groups = ArrayList<Group>()

    fun addStudent(student: Student) {
        if (
            !students.contains(student)
            && students.none { it.id == student.id }
        ) {
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
        if (
            !groups.contains(group)
            && groups.none { it.name == group.name }
        )
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

    fun studentsSize() = students.size

    fun professorsSize() = professors.size

    fun tutorsSize() = tutors.size

    fun workTracksSize() = workTracks.size

    fun groupsSize() = groups.size

    fun getStudents() = students.toArray()

    fun getProfessors() = professors.toArray()

    fun getTutors() = tutors.toArray()

    fun getWorkTracks() = workTracks.toArray()

    fun getGroups() = groups.toArray()
}