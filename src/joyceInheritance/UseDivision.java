package joyceInheritance;

public class UseDivision {
    public static void main(String[] args) {
        Division internationalDivision = new InternationalDivision("International Sales", "12345", "Canada", "French");
        Division domesticDivision = new DomesticDivision("Domestic Sales", "67890", "New York");

        System.out.println("International Division:");
        internationalDivision.display();
        System.out.println();

        System.out.println("Domestic Division:");
        domesticDivision.display();
    }
}
