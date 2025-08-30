package joyceInheritance;

public class DemoPoems {
    public static void main(String[] args) {
        Couplet couplet = new Couplet("Love's Flame");
        System.out.println("Couplet Details:");
        System.out.println("Title: " + couplet.getTitle());
        System.out.println("Lines: " + couplet.getLines());

        Limerick limerick = new Limerick("There Once Was a Man");
        System.out.println("\nLimerick Details:");
        System.out.println("Title: " + limerick.getTitle());
        System.out.println("Lines: " + limerick.getLines());

        Haiku haiku = new Haiku("Nature's Beauty");
        System.out.println("\nHaiku Details:");
        System.out.println("Title: " + haiku.getTitle());
        System.out.println("Lines: " + haiku.getLines());
    }
}
