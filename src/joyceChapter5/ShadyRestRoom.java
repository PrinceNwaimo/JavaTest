package joyceChapter5;

import java.util.Scanner;

public class ShadyRestRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Shady Rest Hotel Room Price Calculator");
        System.out.println("------------------------------------------------");
        System.out.println("Choose a room type:");
        System.out.println("1. Queen bed ($125)");
        System.out.println("2. King bed ($139)");
        System.out.println("3. King bed and pullout couch ($165)");

        int roomType = scanner.nextInt();
        int price = 0;

        switch (roomType) {
            case 1:
                System.out.println("You chose a queen bed.");
                price = 125;
                break;
            case 2:
                System.out.println("You chose a king bed.");
                price = 139;
                break;
            case 3:
                System.out.println("You chose a king bed and pullout couch.");
                price = 165;
                break;
            default:
                System.out.println("Invalid room type. Price set to $0.");
        }

        System.out.println("Room price: $" + price);
    }
}


