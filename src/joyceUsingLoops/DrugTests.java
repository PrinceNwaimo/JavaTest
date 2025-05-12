package joyceUsingLoops;

public class DrugTests {
    public static void main(String[] args) {
        for (int week = 1; week <= 52; week++) {
            int testedEmployee = 1 + (int) (Math.random() * 30);
            System.out.print(String.format("%2d ", testedEmployee));

            if (week % 4 == 0) {
                System.out.println();
            }
        }
    }

}
