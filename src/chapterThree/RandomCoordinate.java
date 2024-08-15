package chapterThree;

import java.util.Random;

public class RandomCoordinate {
    public static void main(String[] args) {
        // Define the rectangle's dimensions
        int width = 100;
        int height = 200;

        // Create a Random object
        Random random = new Random();

        // Generate random x and y coordinates within the rectangle
        int x = random.nextInt(width) - width / 2; // center at 0
        int y = random.nextInt(height) - height / 2; // center at 0

        // Print the random coordinate
        System.out.println("Random coordinate: (" + x + ", " + y + ")");
    }

}
