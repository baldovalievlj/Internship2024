import java.util.*;
import java.util.stream.Collectors;

class Student {
    private final String firstName;
    private final String lastName;
    private final List<Integer> grades;
    private final String classroom;

    public Student(String firstName, String lastName, List<Integer> grades, String classroom) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.grades = grades;
        this.classroom = classroom;
    }

    public Double calculateGPA() {
        return grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    public String getClassroom() {
        return classroom;
    }

    @Override
    public String toString() {
        double average = grades.stream().mapToInt(Integer::intValue).average().orElse(0.0);
        return firstName + " " + lastName + " with [" + average + " average grade in classroom " + classroom + "]";
    }
}

class Teacher {
    private final String firstName;
    private final String lastName;
    private final List<String> classrooms;

    public Teacher(String firstName, String lastName, List<String> classrooms) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.classrooms = classrooms;
    }

    public List<String> getClassrooms() {
        return classrooms;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }
}

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);

        List<Student> students = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();

        while (scanner.hasNextLine()) {
            final String identifier = scanner.nextLine();
            final String[] name = scanner.nextLine().split(" ");
            final String classes = scanner.nextLine();
            if (identifier.equals("S")) {
                final List<Integer> grades = Arrays.stream(scanner.nextLine().split(","))
                        .map(Integer::parseInt)
                        .collect(Collectors.toList());;
                students.add(new Student(name[0], name[1], grades, classes));
            } else {
                teachers.add(new Teacher(name[0], name[1], List.of(classes.split(","))));
            }
        }

        Student bestStudent = students.stream()
                .max(Comparator.comparing(Student::calculateGPA))
                .orElse(null);

        List<Teacher> teachersByRoom = new ArrayList<>();
        for (Teacher teacher : teachers) {
            if (teacher.getClassrooms().contains(bestStudent.getClassroom())) {
                teachersByRoom.add(teacher);
            }
        }

        System.out.println("Best student is " + bestStudent);
        System.out.println("His teachers are " + teachersByRoom);
    }
}
