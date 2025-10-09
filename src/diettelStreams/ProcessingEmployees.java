package diettelStreams;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ProcessingEmployees {
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("Jason", "Red", 5000, "IT"),
                new Employee("Ashley", "Green", 7600, "IT"),
                new Employee("Matthew", "Indigo", 3587.5, "Sales"),
                new Employee("James", "Indigo", 4700.77, "Marketing"),
                new Employee("Luke", "Indigo", 6200, "IT"),
                new Employee("Jason", "Blue", 3200, "Sales"),
                new Employee("Wendy", "Brown", 4236.4, "Marketing")};
        List<Employee> list = Arrays.asList(employees);
        System.out.println("Complete Employee list: ");
        list.stream().forEach(System.out::println);

        //Filtering Employees with salaries in a specified range

        Predicate<Employee> fourToSixThousand = e -> (e.getSalary() >= 4000 && e.getSalary() <= 6000);
        System.out.printf("%nEmployees earning $4000-$6000 per month sorted by salary:%n");
        list.stream()
                .filter(fourToSixThousand)
                .sorted(Comparator.comparing(Employee::getSalary))
                .forEach(System.out::println);
        System.out.printf("%nFirst employee who earns $4000-$5000:%n%s%n", list.stream().filter(fourToSixThousand).findFirst().get());

        // Sorting employees by multiple fields

        Function<Employee, String> byFirstName = Employee::getFirstName;
        Function<Employee, String> byLastName = Employee::getLastName;
        Comparator<Employee> lastThenFirst = Comparator.comparing(byLastName).thenComparing(byFirstName);
        System.out.printf("%nEmployees in ascending order by last name then first:%n");
        list.stream().sorted(lastThenFirst).forEach(System.out::println);
        System.out.printf("%nEmployees in descending order by last name then first:%n");
        list.stream().sorted(lastThenFirst.reversed()).forEach(System.out::println);

        //Mapping Employees to unique last name strings
        System.out.printf("%nUnique employee last names:%n");
        list.stream().map(Employee::getLastName).distinct().sorted().forEach(System.out::println);
        System.out.printf("%nEmployee names in order by last name then first name:%n");
        list.stream().sorted(lastThenFirst).map(Employee::getName).forEach(System.out::println);

        //Grouping Employees by department
        System.out.printf("%nEmployees by department:%n");
        Map<String, List<Employee>> groupedByDepartment = list.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        groupedByDepartment.forEach((department, employeesInDepartment) -> {
            System.out.printf("%n%s%n", department);
            employeesInDepartment.forEach(
                    employee -> System.out.printf("   %s%n", employee));
        });

        // Counting the number of employees in each department
        System.out.printf("%nCount of Employees by department:%n");
        Map<String, Long> employeeCountByDepartment =
                list.stream()
                        .collect(Collectors.groupingBy(Employee::getDepartment,
                                Collectors.counting()));
        employeeCountByDepartment.forEach((department,count) -> System.out.printf("%s has %d employee(s)%n", department,count));

        //Summing and averaging employee salaries
        System.out.printf("%nSum of Employees' salaries(via sum method): %.2f%n",list.stream().mapToDouble(Employee::getSalary).sum());
        System.out.printf("Sum of Employees' salaries(via reduce method): %.2f%n",list.stream().mapToDouble(Employee::getSalary).reduce(0,(value1,value2) -> value1 + value2));
        System.out.printf("Average of Employees' salaries: %.2f%n",list.stream().mapToDouble(Employee::getSalary).average().getAsDouble());
    }
}