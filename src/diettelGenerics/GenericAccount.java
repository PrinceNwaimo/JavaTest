package diettelGenerics;

import chapterThree.Account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenericAccount {
    public static void main(String[] args) {
        List<Account> accounts = new ArrayList<>();
        accounts.add(new Account( "John", 1000));
        accounts.add(new Account( "Mary", 2000));
        accounts.add(new Account( "David", 1500));

        // Sort accounts in descending order based on balance
        Collections.sort(accounts, new AccountComparator());

        // Print sorted accounts
        for (Account account : accounts) {
            System.out.println(" Name: " + account.getName() + ", Balance: " + account.getBalance());
        }
    }
}
