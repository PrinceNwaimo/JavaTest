package chapterThree;

import java.util.Scanner;

public class JobPricing {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Name of the Job: ");
        String name = input.nextLine();
        System.out.print("Cost of the material ($): ");
        double cost = input.nextDouble();
        System.out.print("Number of hours worked: ");
        int work = input.nextInt();
        System.out.print("Number of hours travel time: ");
        int time = input.nextInt();
        job(cost,time,work);
    }
    private static void job(double cost, int time, int work){
        int workCal = 35 * work;
        int travelCal = 12 * time;
        double compute = cost + workCal + travelCal;
        System.out.println("The cost of the job is $"+compute);
    }
}
