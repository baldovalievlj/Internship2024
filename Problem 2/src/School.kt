class Student(
    val firstName: String,
    val lastName: String,
    val grades: List<Int>,
    val classroom: String,
) {
    override fun toString(): String {
        return "$firstName $lastName with [${String.format("%.2f", grades.average())} average grade in classroom ${classroom}]"
    }
}

class Teacher(
    val firstName: String,
    val lastName: String,
    val classrooms: List<String>,
) {
    override fun toString(): String {
        return "$firstName $lastName"
    }
}

fun readStudent(): Student {
    val name: List<String> = readln().split(" ")
    val classes: String = readln()
    val grades = readln().split(",").map(String::toInt)
    return Student(name[0], name[1], grades, classes)
}

fun readTeacher(): Teacher {
    val name: List<String> = readln().split(" ")
    val classes: List<String> = readln().split(",")
    return Teacher(name[0], name[1], classes)
}

fun main() {
    val students: MutableList<Student> = mutableListOf()
    val teachers: MutableList<Teacher> = mutableListOf()

    while (true) {
        val identifier: String = readlnOrNull() ?: break
        when(identifier) {
            "S" -> students.add(readStudent())
            "T" -> teachers.add(readTeacher())
        }
    }

    val bestStudent = students.maxBy { it.grades.average() }
    val teachersByRoom = teachers.filter { it.classrooms.contains(bestStudent.classroom) }
    println("Best student is $bestStudent")
    println("His teachers are $teachersByRoom")
}