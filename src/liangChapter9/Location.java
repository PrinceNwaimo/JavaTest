package liangChapter9;

import java.util.Scanner;

public class Location {
    public int row;
    public int column;
    public double maxValue;

    public Location(int row, int column, double maxValue) {
        this.row = row;
        this.column = column;
        this.maxValue = maxValue;
    }

    public static Location locateLargest(double[][] a) {
        int row = 0;
        int column = 0;
        double maxValue = a[0][0];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] > maxValue) {
                    maxValue = a[i][j];
                    row = i;
                    column = j;
                }
            }
        }

        return new Location(row, column, maxValue);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rows and columns in the array: ");
        int rows = scanner.nextInt();
        int columns = scanner.nextInt();

        double[][] array = new double[rows][columns];

        System.out.println("Enter the array:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                array[i][j] = scanner.nextDouble();
            }
        }

        Location location = locateLargest(array);

        System.out.println("The location of the largest element is " + location.maxValue + " at (" + location.row + ", " + location.column + ")");
    }
}
