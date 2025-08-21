package liangInheritance.account;

public class Test {
    public static void main(String[] args) {
        Account account = new Account(1, 1000, 5);
        SavingsAccount savingsAccount = new SavingsAccount(2, 2000, 4);
        CheckingAccount checkingAccount = new CheckingAccount(3, 3000, 6, 500);

        System.out.println(account.toString());
        System.out.println(savingsAccount.toString());
        System.out.println(checkingAccount.toString());
    }
}
