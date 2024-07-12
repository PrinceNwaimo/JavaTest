package chapterThree;

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Account myAccount = new Account();
        System.out.printf("Initial Name is : %s%n%n", myAccount.getName());
        System.out.println("Please  enter the name: ");
        String newName = input.nextLine();
        myAccount.setName(newName);
        System.out.println();
        System.out.println("Name in object myAccount is:"+ myAccount.getName());
    }
}
