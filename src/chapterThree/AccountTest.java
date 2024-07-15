package chapterThree;

import java.util.Scanner;

public class AccountTest {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Account myAccount = new Account("Fidelity Bank", 1000);
        Account account1 = new Account("Diamond Bank", 0.0);
        System.out.printf("Initial Name is : %s%n%n", myAccount.getName(),myAccount.getBalance());
        System.out.printf("Initial Name is : %s%n%n", account1.getName(), myAccount.getBalance());
        System.out.println("Please  enter the name: ");
        String newName = input.nextLine();
        myAccount.setName(newName);
        System.out.println("Name of Second Account: ");
        String newName1 = input.nextLine();
        account1.setName(newName1);
        System.out.println();
        System.out.println("Name in object myAccount is: " + myAccount.getName()+","+myAccount.getBalance());
        System.out.println("Name of account 1 holder is now: "+account1.getName()+","+account1.getBalance());

    }
}
