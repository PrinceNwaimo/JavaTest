package diettel6;

public class NumberSystemsTable {
    public static void main(String[] args) {
        System.out.printf("%-10s %-10s %-10s %-10s%n", "Decimal", "Binary", "Octal", "Hexadecimal");
        System.out.println("---------------------------------------------------------");

        for (int i = 1; i <= 256; i++) {
            String binary = Integer.toBinaryString(i);
            String octal = Integer.toOctalString(i);
            String hexadecimal = Integer.toHexString(i).toUpperCase();

            System.out.printf("%-10d %-10s %-10s %-10s%n", i, binary, octal, hexadecimal);
        }
    }

}
