package liangInheritance;

public class TestCourse {
    public static void main(String[] args) {
        Course course = new Course("Math");
        course.addStudent("John");
        course.addStudent("Jane");
        course.addStudent("Bob");
        System.out.println("Number of students: " + course.getNumberOfStudents());
        System.out.println("Students: " + course.getStudents());
        course.dropStudent("Jane");
        System.out.println("Number of students after dropping Jane: " + course.getNumberOfStudents());
        System.out.println("Students after dropping Jane: " + course.getStudents());
    }
}
