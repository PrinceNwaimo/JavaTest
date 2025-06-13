package liangChapter6;

public class LengthConverter {
    public static void main(String[] args) {
        System.out.println("Feet\tMeters | Meters\tFeet");
        for (int i = 1; i <= 10; i++) {
            double feet = i;
            double meters = 15 + i * 5;
            System.out.printf("%.1f\t%.3f | %.1f\t%.3f\n", feet, footToMeter(feet), meters, meterToFoot(meters));
        }
    }

    public static double footToMeter(double foot) {
        return 0.305 * foot;
    }

    public static double meterToFoot(double meter) {
        return 3.279 * meter;
    }

}
