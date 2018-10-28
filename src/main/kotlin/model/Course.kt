package model

class Course(val name: String, val year: Int) {
    private val students = ArrayList<Student>()
    private val professors = ArrayList<Professor>()
    private val tutors = ArrayList<Tutor>()
    private val workTracks = ArrayList<WorkTrack>()
    private val groups = ArrayList<Group>()

    fun addStudent(student: Student): Boolean {
        return if (
            !students.contains(student)
            && students.none { it.id == student.id }
        ) {
            students.add(student)
            student.course = this
            true
        } else false
    }

    fun removeStudent(student: Student) {
        if (students.contains(student)) {
            students.remove(student)
            student.course = null
        }
    }

    fun addGroup(group: Group): Boolean {
        return if (
            !groups.contains(group)
            && groups.none { it.name == group.name }
        ) {
            groups.add(group)
            true
        } else false
    }

    fun removeGroup(group: Group) {
        if (groups.contains(group))
            groups.remove(group)
    }

    fun addWorkTrack(workTrack: WorkTrack): Boolean {
        return if (!workTracks.contains(workTrack)) {
            workTracks.add(workTrack)
            true
        } else false
    }

    fun removeWorkTrack(workTrack: WorkTrack) {
        if (workTracks.contains(workTrack))
            workTracks.remove(workTrack)
    }

    fun addTeacher(teacher: User): Boolean {
        when (teacher) {
            is Professor -> {
                return if (!professors.contains(teacher)) {
                    professors.add(teacher)
                    true
                } else false
            }
            is Tutor-> {
                return if (!tutors.contains(teacher)) {
                    tutors.add(teacher)
                    true
                } else false
            }
            else -> return false
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

    fun getStudent(studentID: Int): Student? {
        return if (students.size > studentID)
            students[studentID]
        else null
    }

    fun getProfessor(professorID: Int): Professor? {
        return if (professors.size > professorID)
            professors[professorID]
        else null
    }

    fun getTutor(tutorID: Int): Tutor? {
        return if (tutors.size > tutorID)
            tutors[tutorID]
        else null
    }

    fun getWorkTrack(workTrackID: Int): WorkTrack? {
        return if (workTracks.size > workTrackID)
            workTracks[workTrackID]
        else null
    }

    fun getGroup(groupID: Int): Group? {
        return if (groups.size > groupID)
            groups[groupID]
        else null
    }
}