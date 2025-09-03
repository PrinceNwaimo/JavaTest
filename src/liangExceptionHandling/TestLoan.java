package liangExceptionHandling;

public class TestLoan {
    public static void main(String[] args) {
        try {
            Loan loan = new Loan(-2.5, 1, 1000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Loan loan = new Loan(2.5, -1, 1000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            Loan loan = new Loan(2.5, 1, -1000);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
