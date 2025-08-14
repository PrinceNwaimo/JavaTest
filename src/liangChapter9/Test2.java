package liangChapter9;

import java.util.Random;

public class Test2 {
    public static void main(String[] args) {
        Random random = new Random(1000);

        System.out.println("First 50 random integers between 0 and 100:");
        for (int i = 0; i < 50; i++) {
            System.out.print(random.nextInt(100) + " ");
            if ((i + 1) % 10 == 0) {
                System.out.println();
            }
        }
    }
}
