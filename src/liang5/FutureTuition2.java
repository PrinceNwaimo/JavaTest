package liang5;

public class FutureTuition2 {
    public static void main(String[] args) {

        double tuition = 10000;
        int year = 0;
        int years =0;
        double totalCost = 0;

        while (year < 10) {
            tuition = tuition * 1.05;
            year++;

            while (years < 4){
                totalCost =  totalCost + tuition ;
                years++;
            }
        }

        System.out.println("Tuition will be defined in "+ year + " years ");
        System.out.printf("Tuition will be $%.2f in %1d years", tuition, year);
        System.out.printf(" Total cost of Tuition will be $%.2f in %1d years", totalCost, years);

    }
}
