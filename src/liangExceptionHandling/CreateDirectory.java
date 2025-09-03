package liangExceptionHandling;

import java.io.File;
import java.util.Scanner;

public class CreateDirectory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a directory name: ");
        String directoryName = scanner.nextLine();
        scanner.close();

        File directory = new File(directoryName);
        if (directory.exists()) {
            System.out.println("Directory already exists");
        } else {
            if (directory.mkdirs()) {
                System.out.println("Directory created successfully");
            } else {
                System.out.println("Error creating directory");
            }
        }
    }
}
