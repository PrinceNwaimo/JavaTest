package diettel8;

public class HugeInteger {
    private int[] digits;
    private boolean isNegative;

    public HugeInteger() {
        digits = new int[40];
    }

    public static HugeInteger parse(String num) {
        HugeInteger hugeInteger = new HugeInteger();

        if (num.startsWith("-")) {
            hugeInteger.isNegative = true;
            num = num.substring(1);
        }

        for (int i = 0; i < num.length(); i++) {
            hugeInteger.digits[40 - num.length() + i] = Character.getNumericValue(num.charAt(i));
        }

        return hugeInteger;
    }
    public static boolean isLessThan(HugeInteger num1, HugeInteger num2) {
        return !isGreaterThan(num1, num2) && !isEqualTo(num1, num2);
    }

    public static boolean isGreaterThanOrEqualTo(HugeInteger num1, HugeInteger num2) {
        return isGreaterThan(num1, num2) || isEqualTo(num1, num2);
    }

    public static boolean isLessThanOrEqualTo(HugeInteger num1, HugeInteger num2) {
        return isLessThan(num1, num2) || isEqualTo(num1, num2);
    }

    public static boolean isZero(HugeInteger num) {
        for (int digit : num.digits) {
            if (digit != 0) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (isNegative) {
            sb.append("-");
        }

        boolean started = false;
        for (int digit : digits) {
            if (digit != 0 || started) {
                started = true;
                sb.append(digit);
            }
        }

        if (!started) {
            sb.append("0");
        }

        return sb.toString();
    }

    public static HugeInteger add(HugeInteger num1, HugeInteger num2) {
        HugeInteger result = new HugeInteger();
        int carry = 0;

        if (num1.isNegative && num2.isNegative) {
            result.isNegative = true;
        } else if (num1.isNegative) {
            num1.isNegative = false;
            HugeInteger temp = subtract(num2, num1);
            num1.isNegative = true;
            return temp;
        } else if (num2.isNegative) {
            num2.isNegative = false;
            HugeInteger temp = subtract(num1, num2);
            num2.isNegative = true;
            return temp;
        }

        for (int i = 39; i >= 0; i--) {
            int sum = num1.digits[i] + num2.digits[i] + carry;
            result.digits[i] = sum % 10;
            carry = sum / 10;
        }

        return result;
    }

    public static HugeInteger subtract(HugeInteger num1, HugeInteger num2) {
        HugeInteger result = new HugeInteger();

        if (num1.isNegative && num2.isNegative) {
            num1.isNegative = false;
            num2.isNegative = false;
            HugeInteger temp = subtract(num2, num1);
            num1.isNegative = true;
            num2.isNegative = true;
            temp.isNegative = !temp.isNegative;
            return temp;
        } else if (num1.isNegative) {
            num1.isNegative = false;
            HugeInteger temp = add(num1, num2);
            num1.isNegative = true;
            temp.isNegative = true;
            return temp;
        } else if (num2.isNegative) {
            num2.isNegative = false;
            HugeInteger temp = add(num1, num2);
            num2.isNegative = true;
            return temp;
        }

        if (isLessThan(num1, num2)) {
            HugeInteger temp = subtract(num2, num1);
            temp.isNegative = true;
            return temp;
        }

        for (int i = 39; i >= 0; i--) {
            int diff = num1.digits[i] - num2.digits[i];

            if (diff < 0) {
                num1.digits[i - 1]--;
                diff += 10;
            }

            result.digits[i] = diff;
        }

        return result;
    }


    public static boolean isEqualTo(HugeInteger num1, HugeInteger num2) {
        for (int i = 0; i < 40; i++) {
            if (num1.digits[i] != num2.digits[i]) {
                return false;
            }
        }

        return num1.isNegative == num2.isNegative;
    }

    public static boolean isNotEqualTo(HugeInteger num1, HugeInteger num2) {
        return !isEqualTo(num1, num2);
    }

    public static boolean isGreaterThan(HugeInteger num1, HugeInteger num2) {
        if (num1.isNegative && !num2.isNegative) {
            return false;
        } else if (!num1.isNegative && num2.isNegative) {
            return true;
        } else if (num1.isNegative && num2.isNegative) {
            return isLessThan(num2, num1);
        }

        for (int i = 0; i < 40; i++) {
            if (num1.digits[i] > num2.digits[i]) {
                return true;
            } else if (num1.digits[i] < num2.digits[i]) {
                return false;

            }
        }
        return true;
    }

}