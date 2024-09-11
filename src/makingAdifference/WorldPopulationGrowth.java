package makingAdifference;

public class WorldPopulationGrowth {
    public static void main(String[] args) {
        double currentPopulation = 7.92e9; // current world population in billions
        double growthRate = 0.012; // current growth rate (1.2%)

        System.out.println("Year\tPopulation (billions)\tIncrease (billions)");

        for (int year = 1; year <= 75; year++) {
            double population = currentPopulation * Math.pow(1 + growthRate, year);
            double increase = population - currentPopulation * Math.pow(1 + growthRate, year - 1);

            System.out.printf("%d\t%.2f\t\t%.2f%n", year, population, increase);

            if (population >= 2 * currentPopulation) {
                System.out.println("Population will double by year " + year);
                break;
            }
        }
    }

}
