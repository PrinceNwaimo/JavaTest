package networkProgramming;
import java.io.*;
import java.net.*;
import java.util.Scanner;
import java.text.DecimalFormat;
public class LoanerClient {
public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        // Create a scanner
        Scanner input = new Scanner(System.in);

        // Get user input
        System.out.print("Enter annual interest rate, for example, 8.25: ");
        double annualInterestRate = input.nextDouble();
        System.out.print("Enter number of years as an integer: ");
        int numberOfYears = input.nextInt();
        System.out.print("Enter loan amount, for example, 120000.95: ");
        double loanAmount = input.nextDouble();

        // Create a loan object
        Loaner loan = new Loaner(annualInterestRate, numberOfYears, loanAmount);

        // Create a socket
        Socket socket = new Socket("localhost", 8000);

        // Create output and input streams
        ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());
        ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());

        // Send loan object to server
        toServer.writeObject(loan);

        // Receive results from server
        double monthlyPayment = (double) fromServer.readObject();
        double totalPayment = (double)fromServer.readObject();

        // Display results
        DecimalFormat df = new DecimalFormat("0.00");
        System.out.println("Monthly Payment: " + df.format(monthlyPayment));
        System.out.println("Total Payment: " + df.format(totalPayment));

        // Close streams and socket
        toServer.close();
        fromServer.close();
        socket.close();
    }
}