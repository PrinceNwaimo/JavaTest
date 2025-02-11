package chapterThree;

import java.util.Scanner;

public class SammysRentalPrice {


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of minutes ");
        int minutes = input.nextInt();
        motto();
        time(minutes);




    }
    private static void time(int minutes){
        int hour = minutes / 60;
        int remainder = minutes % 60;
        System.out.println("Time spent is "+hour +"hours"+" "+remainder+"minutes"+" ");

         double costPerHour = 40 * hour;
        double costPerMinute = remainder;
        double totalPrice = costPerHour + costPerMinute;
        System.out.println("Total Price is ₦"+totalPrice);

    }

    private static void motto(){
        System.out.println("We promise to deliver the best for your rentals");
    }
}
