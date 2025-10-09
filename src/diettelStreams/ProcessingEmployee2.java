package diettelStreams;
import java.util.*;
import java.util.stream.*;


public class ProcessingEmployee2 {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John","Locke",50000,"Sales"),
                new Employee("Jane","Osuagwu",60000,"Marketing"),
                new Employee("Bob", "Manuel",55000,"Sales"),
                new Employee("Alice", "Effiong",65000,"Marketing"),
                new Employee("Mike", "Murdock",70000,"IT")
        );

        Map<String, Double> averageSalaries = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)));

        averageSalaries.forEach((department, averageSalary) ->
                System.out.printf("Department: %s, Average Salary: %.2f%n", department, averageSalary));
    }
}
