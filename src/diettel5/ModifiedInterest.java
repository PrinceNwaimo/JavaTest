package diettel5;

public class ModifiedInterest {
    public static void main(String[] args) {
        double principal = 1000.0;
        double rate = 0.05;

        System.out.printf("%s%20s%n", "Year","Amount on deposit");
        for(int year = 1; year <= 10; ++year){
            for ( double rateTrack = rate; rateTrack <=0.10 ; rateTrack++) {

                double amount = principal * Math.pow(1.0 + rateTrack, year);

                System.out.printf("%4d%,20.2f%n", year, amount);
            }
        }
    }
}

