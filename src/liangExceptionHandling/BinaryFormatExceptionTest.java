package liangExceptionHandling;

public class BinaryFormatExceptionTest {
    public static int bin2Dec(String binaryString) throws BinaryFormatException {
        binaryString = binaryString.trim();
        for (char c : binaryString.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new BinaryFormatException("Not a binary string: " + binaryString);
            }
        }
        return Integer.parseInt(binaryString, 2);
    }

    public static void main(String[] args) {
        try {
            System.out.println(bin2Dec("1010"));
        } catch (BinaryFormatException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(bin2Dec("1012"));
        } catch (BinaryFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
