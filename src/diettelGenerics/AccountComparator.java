package diettelGenerics;



import chapterThree.Account;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class AccountComparator implements Comparator<Account> {
    @Override
    public int compare(Account a1, Account a2) {
        // Compare accounts based on balance in descending order
        if (a1.getBalance() > a2.getBalance()) {
            return -1; // a1 has higher balance, so it comes first
        } else if (a1.getBalance() < a2.getBalance()) {
            return 1; // a2 has higher balance, so it comes first
        } else {
            return 0; // Both accounts have the same balance
        }
    }
}
