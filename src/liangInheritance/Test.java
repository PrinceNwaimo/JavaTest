package liangInheritance;

public class Test {
    public static void main(String[] args) {
        Person person = new Person("John Doe", "123 Main St", "123-456-7890", "john.doe@example.com");
        Student student = new Student("Jane Doe", "456 Elm St", "987-654-3210", "jane.doe@example.com", Student.FRESHMAN);
        MyDate dateHired = new MyDate(2020, 1, 1);
        Employee employee = new Employee("Bob Smith", "789 Oak St", "555-123-4567", "bob.smith@example.com", "101", 50000, dateHired);
        Faculty faculty = new Faculty("Alice Johnson", "321 Maple St", "901-234-5678", "alice.johnson@example.com", "202", 60000, dateHired, "10:00-11:00", "Professor");
        Staff staff = new Staff("Mike Brown", "901 Pine St", "111-222-3333", "mike.brown@example.com", "303", 40000, dateHired, "Administrative Assistant");

        System.out.println(person.toString());
        System.out.println(student.toString());
        System.out.println(employee.toString());
        System.out.println(faculty.toString());
        System.out.println(staff.toString());
    }
}
