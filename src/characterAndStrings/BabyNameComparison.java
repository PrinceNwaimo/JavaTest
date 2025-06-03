package characterAndStrings;

import java.util.Scanner;

public class BabyNameComparison {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the first name:");
        String name1 = scanner.nextLine();

        System.out.println("Enter the second name:");
        String name2 = scanner.nextLine();

        System.out.println("Enter the third name:");
        String name3 = scanner.nextLine();

        String[][] combinations = {
                {name1, name2},
                {name1, name3},
                {name2, name1},
                {name2, name3},
                {name3, name1},
                {name3, name2}
        };

        System.out.println("Possible two-name combinations:");
        for (String[] combination : combinations) {
            System.out.println(combination[0] + " " + combination[1]);
        }

        scanner.close();
    }

}
