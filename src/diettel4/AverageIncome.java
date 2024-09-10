package diettel4;

import java.util.Scanner;

public class AverageIncome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        int total = 0;
        int incomeCounter =0;
        System.out.print("Enter first income or press -1 to quit:");
        int income = input.nextInt();

        while(income != -1){
            total = total + income;
            incomeCounter = incomeCounter + 1;

            System.out.print("Enter first income or press -1 to quit:");
            income = input. nextInt();
        }
        if(incomeCounter != 0){
            double average = (double) total/incomeCounter;
            System.out.printf("%n The total of %d income is %d%n",incomeCounter,total);
            System.out.printf("The average income is %.2f%n",average);
        }
        else{
            System.out.println("No income entered yet");
        }
    }
}
