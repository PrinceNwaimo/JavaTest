package liangChapter6;

public class CommissionCalculator {
    public static void main(String[] args) {
        System.out.println("Sales Amount\tCommission");
        for (int salesAmount = 10000; salesAmount <= 100000; salesAmount += 5000) {
            double commission = computeCommission(salesAmount);
            System.out.printf("%d\t%.1f\n", salesAmount, commission);
        }
    }

    public static double computeCommission(double salesAmount) {
        double commission;
        if (salesAmount >= 10000 && salesAmount <= 50000) {
            commission = salesAmount * 0.08 + 5000 * 0.1;
            if (salesAmount > 50000) {
                commission = 50000 * 0.08 + (salesAmount - 50000) * 0.12 + 5000 * 0.1;
            }
        } else if (salesAmount > 50000) {
            commission = 50000 * 0.08 + (salesAmount - 50000) * 0.12 + 5000 * 0.1;
        } else if (salesAmount > 0 && salesAmount < 5000) {
            commission = salesAmount * 0.1;
        } else {
            commission = 5000 * 0.1 + (salesAmount - 5000) * 0.08;
        }
        return commission;
    }

}
