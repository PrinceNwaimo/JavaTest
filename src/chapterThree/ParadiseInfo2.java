package chapterThree;

import java.util.Scanner;

public class ParadiseInfo2 {

    public static void main(String[] args) {
        double price;
        double discount;
        double savings;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter cutoff price for discount >> ");
        price = input.nextDouble();
        System.out.print("Enter discount rate as a whole number >> ");
        discount = input.nextDouble();

        savings = computeDiscountInfo(price, discount);
        System.out.println("Special this week on any service over " + price);
        System.out.println("Discount of "+ discount +"percent");
        System.out.println("That's a savings of at least $"+ savings);

    }
    public static double computeDiscountInfo(double price, double discount){
        double savings;
        savings = price * discount / 100;
        return savings;
    }
}
