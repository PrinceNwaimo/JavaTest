package joyceInheritance;

public class DemoStudent {
    public static void main(String[] args) {
        Student2[] students = new Student2[6];

        students[0] = new UndergraduateStudent(1, "Smith");
        students[1] = new UndergraduateStudent(2, "Johnson");
        students[2] = new GraduateStudent(3, "Williams");
        students[3] = new GraduateStudent(4, "Jones");
        students[4] = new StudentAtLarge(5, "Brown");
        students[5] = new StudentAtLarge(6, "Davis");

        for (Student2 student : students) {
            System.out.println("Student ID: " + student.getStudentID());
            System.out.println("Last Name: " + student.getLastName());
            System.out.println("Annual Tuition: $" + student.getAnnualTuition());
            System.out.println();
        }
    }
}
