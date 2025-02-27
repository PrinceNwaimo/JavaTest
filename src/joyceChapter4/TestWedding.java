package joyceChapter4;

import java.time.LocalDate;

public class TestWedding {
    public static void main(String[] args) {
        Person person1 = new Person("John", "Doe", LocalDate.of(1990, 1, 1));
        Person person2 = new Person("Jane", "Doe", LocalDate.of(1992, 6, 15));
        Person person3 = new Person("Bob", "Smith", LocalDate.of(1985, 3, 20));
        Person person4 = new Person("Alice", "Johnson", LocalDate.of(1988, 9, 10));


        Couple couple1 = new Couple(person1, person2);
        Couple couple2 = new Couple(person3, person4);

        Wedding wedding1 = new Wedding(LocalDate.of(2022, 6, 20), couple1, "New York");
        Wedding wedding2 = new Wedding(LocalDate.of(2023, 9, 15), couple2, "Los Angeles");


        displayWeddingDetails(wedding1);
        displayWeddingDetails(wedding2);
    }

    public static void displayWeddingDetails(Wedding wedding) {
        System.out.println("Wedding Details:");
        System.out.println("Wedding Date: " + wedding.getWeddingDate());
        System.out.println("Couple:");
        System.out.println("Person 1: " + wedding.getCouple().getPerson1().getFirstName() + " " + wedding.getCouple().getPerson1().getLastName());
        System.out.println("Birthdate: " + wedding.getCouple().getPerson1().getBirthdate());
        System.out.println("Person 2: " + wedding.getCouple().getPerson2().getFirstName() + " " + wedding.getCouple().getPerson2().getLastName());
        System.out.println("Birthdate: " + wedding.getCouple().getPerson2().getBirthdate());
        System.out.println("Location: " + wedding.getLocation());
        System.out.println();
    }
}
