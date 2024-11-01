package liang5;

public class MilesToKm {
    public static void main(String[] args) {
        System.out.printf("%-10s %-10s  | %-10s %-10s%n","Miles","Kilometers","Miles","Kilometers");
        int KilometersStart = 20;
        for (int Miles = 1; Miles <+ 10 ; Miles++) {
            double kilometers = Miles * 1.609;
            double MilesFromKilo = KilometersStart * 0.6215;

            System.out.printf("%-10d %-10.3f | %-10d %-10.3f%n", Miles,kilometers, KilometersStart, MilesFromKilo);
            KilometersStart += 5;

        }
    }
}
