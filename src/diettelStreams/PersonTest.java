package diettelStreams;

import java.util.Arrays;
import java.util.List;

public class PersonTest {
    public static void main(String[] args) {
        List<Person> people = Arrays.asList(
                new Person("John", "Doe"),
                new Person("Jane", "Jones"),
                new Person("Bob", "Smith"),
                new Person("Alice", "Jones"),
                new Person("Mike", "Johnson")
        );

        Person firstJones = people.stream()
                .filter(person -> person.getLastName().equals("Jones"))
                .findFirst()
                .orElse(null);

        if (firstJones != null) {
            System.out.println("First person with last name Jones: " + firstJones);
        } else {
            System.out.println("No person with last name Jones found.");
        }
    }
}
