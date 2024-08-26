package mathsClasses;

public class RandomCharacter {
    public static void main(String[] args) {
        // Generate a random number between 0 and 25
        int rand = (int) (Math.random() * 26);

        // Convert the number to an uppercase letter
        char letter = (char) ('A' + rand);

        // Display the letter
        System.out.println("Random uppercase letter: " + letter);
    }
}
