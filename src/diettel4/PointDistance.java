package diettel4;

import java.util.Scanner;

public class PointDistance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter x and y coordinates of point 1:");
        int x1 = scanner.nextInt();
        int y1 = scanner.nextInt();

        System.out.println("Enter x and y coordinates of point 2:");
        int x2 = scanner.nextInt();
        int y2 = scanner.nextInt();

        if (x1 == x2) {
            System.out.println("Points are located on a line perpendicular to the y-axis.");
        } else if (y1 == y2) {
            System.out.println("Points are located on a line perpendicular to the x-axis.");
        } else {
            System.out.println("Points are not located on a line perpendicular to an axis.");
        }
    }

}
