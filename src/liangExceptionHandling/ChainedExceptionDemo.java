package liangExceptionHandling;

public class ChainedExceptionDemo {
    public static void main(String[] args) {
        try {
            method1();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }


    public static void method1() throws Exception {

        try {
            method2();
        } catch (Exception ex) {
            throw new Exception("New information from method1", ex);

        }
    }

    public static void method2() throws Exception {
        throw new Exception("New information from method2");
    }

    public static int hex2Dec(String hexString) {
        try {
            return Integer.parseInt(hexString, 16);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Not a hex string: " + hexString);
        }

    }
    public static int hex2Dec2(String hexString) {
        hexString = hexString.trim().toLowerCase();
        for (char c : hexString.toCharArray()) {
            if (!((c >= '0' && c <= '9') || (c >= 'a' && c <= 'f'))) {
                throw new NumberFormatException("Not a hex string: " + hexString);
            }
        }
        return Integer.parseInt(hexString, 16);
    }

    public static int bin2Dec(String binaryString) {
        binaryString = binaryString.trim();
        for (char c : binaryString.toCharArray()) {
            if (c != '0' && c != '1') {
                throw new NumberFormatException("Not a binary string: " + binaryString);
            }
        }
        return Integer.parseInt(binaryString, 2);
    }
    
}
