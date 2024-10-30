package liang5;

public class KilogramsToPounds {
    public static void main(String[] args) {
        System.out.println("Kilograms" +"     "+"Pounds");

        for (int kilograms = 1; kilograms < 200 ; kilograms+=2) {
            double POUNDS = kilograms * 2.2;

            System.out.printf("%d          %4.2f%n",kilograms ,POUNDS);

        }

    }
}
