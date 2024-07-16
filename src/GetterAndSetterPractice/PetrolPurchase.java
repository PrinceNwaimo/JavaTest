package GetterAndSetterPractice;

import java.sql.SQLOutput;
import java.util.Scanner;

public class PetrolPurchase {
    public static void main(String[] args) {
        Petrol Ababa = new Petrol("Lagos","Sulphur",0,700.00,10.00);
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the quantity to purchase >> ");
        int quantity = input.nextInt();
        Ababa.setQuantity(quantity);

        System.out.println("Pay $"+Ababa.getPurchaseAmount());
    }

}
