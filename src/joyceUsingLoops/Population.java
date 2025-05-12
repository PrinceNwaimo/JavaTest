package joyceUsingLoops;

public class Population {
    public static void main(String[] args) {
        double mexicoPopulation = 128000000;
        double usPopulation = 323000000;
        double mexicoGrowthRate = 1.0101;
        double usGrowthRate = 0.9985;
        int years = 0;

        System.out.println("Year\tMexico Population\tUS Population");

        while (mexicoPopulation <= usPopulation) {
            System.out.printf("%d\t%.2f million\t%.2f million%n", years, mexicoPopulation / 1000000, usPopulation / 1000000);
            mexicoPopulation *= mexicoGrowthRate;
            usPopulation *= usGrowthRate;
            years++;
        }

        System.out.printf("%d\t%.2f million\t%.2f million%n", years, mexicoPopulation / 1000000, usPopulation / 1000000);
        System.out.println("It took " + years + " years for Mexico's population to exceed the US population.");
    }

}
