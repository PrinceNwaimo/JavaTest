package liangExceptionHandling;

public class HexFormatExceptionTest {
    public static int hex2Dec(String hexString) throws HexFormatException {
        hexString = hexString.trim().toLowerCase();
        for (char c : hexString.toCharArray()) {
            if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f'))) {
                throw new HexFormatException("Not a hex string: " + hexString);
            }
        }
        return Integer.parseInt(hexString, 16);
    }

    public static void main(String[] args) {
        try {
            System.out.println(hex2Dec("A"));
        } catch (HexFormatException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println(hex2Dec("A1G"));
        } catch (HexFormatException e) {
            System.out.println(e.getMessage());
        }
    }
}
