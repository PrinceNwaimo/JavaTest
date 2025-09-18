package diettelFiles.transaction;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class FileMatch {
        public static void main(String[] args) {
            try (Scanner oldMasterScanner = new Scanner(Paths.get("oldmast.txt"));
                 Scanner transactionScanner = new Scanner(Paths.get("trans.txt"));
                 Formatter newMasterFormatter = new Formatter("newmast.txt");
                 Formatter logFormatter = new Formatter("log.txt")) {

                Account oldMasterAccount = getNextAccount(oldMasterScanner);
                TransactionRecord transactionRecord = getNextTransaction(transactionScanner);

                while (oldMasterAccount != null || transactionRecord != null) {
                    if (oldMasterAccount == null) {
                        logFormatter.format("Unmatched transaction record for account number %d%n", transactionRecord.getAccountNumber());
                        transactionRecord = getNextTransaction(transactionScanner);
                    } else if (transactionRecord == null) {
                        newMasterFormatter.format("%d %s %s %.2f%n", oldMasterAccount.getAccountNumber(), oldMasterAccount.getFirstName(), oldMasterAccount.getLastName(), oldMasterAccount.getBalance());
                        oldMasterAccount = getNextAccount(oldMasterScanner);
                    } else if (oldMasterAccount.getAccountNumber() < transactionRecord.getAccountNumber()) {
                        newMasterFormatter.format("%d %s %s %.2f%n", oldMasterAccount.getAccountNumber(), oldMasterAccount.getFirstName(), oldMasterAccount.getLastName(), oldMasterAccount.getBalance());
                        oldMasterAccount = getNextAccount(oldMasterScanner);
                    } else if (oldMasterAccount.getAccountNumber() > transactionRecord.getAccountNumber()) {
                        logFormatter.format("Unmatched transaction record for account number %d%n", transactionRecord.getAccountNumber());
                        transactionRecord = getNextTransaction(transactionScanner);
                    } else {
                        while (transactionRecord != null && transactionRecord.getAccountNumber() == oldMasterAccount.getAccountNumber()) {
                            oldMasterAccount.combine(transactionRecord);
                            transactionRecord = getNextTransaction(transactionScanner);
                        }
                        newMasterFormatter.format("%d %s %s %.2f%n", oldMasterAccount.getAccountNumber(), oldMasterAccount.getFirstName(), oldMasterAccount.getLastName(), oldMasterAccount.getBalance());
                        oldMasterAccount = getNextAccount(oldMasterScanner);
                    }
                }

            } catch (IOException | FormatterClosedException | NoSuchElementException e) {
                System.err.println("Error processing files.");
                e.printStackTrace();
            }
        }

        private static Account getNextAccount(Scanner scanner) {
            try {
                int accountNumber = scanner.nextInt();
                String firstName = scanner.next();
                String lastName = scanner.next();
                double balance = scanner.nextDouble();
                return new Account(accountNumber, firstName, lastName, balance);
            } catch (NoSuchElementException e) {
                return null;
            }
        }

        private static TransactionRecord getNextTransaction(Scanner scanner) {
            try {
                int accountNumber = scanner.nextInt();
                double amount = scanner.nextDouble();
                return new TransactionRecord(accountNumber, amount);
            } catch (NoSuchElementException e) {
                return null;
            }
        }
}
