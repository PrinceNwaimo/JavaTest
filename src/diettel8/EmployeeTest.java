package diettel8;

public class EmployeeTest {
    public static void main(String[] args) {
        Date birth = new Date(3, 8 ,1990);
        Date hire = new Date(3,12,2005);
        Employee employee = new Employee("Prince", "Nwaimo", birth,hire);
        System.out.println(employee);
    }
}
