package networkProgramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class LoanClient {

    public static void main(String[] args) throws UnknownHostException, IOException {
        // Create a scanner
        Scanner input = new Scanner(System.in);

        // Get user input
        System.out.print("Enter annual interest rate, for example, 8.25: ");
        double annualInterestRate = input.nextDouble();
        System.out.print("Enter number of years as an integer: ");
        int numberOfYears = input.nextInt();
        System.out.print("Enter loan amount, for example, 120000.95: ");
        double loanAmount = input.nextDouble();

        // Create a socket
        Socket socket = new Socket("localhost", 8000);

        // Create output and input streams
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
        DataInputStream fromServer = new DataInputStream(socket.getInputStream());

        // Send data to server
        toServer.writeDouble(annualInterestRate);
        toServer.writeInt(numberOfYears);
        toServer.writeDouble(loanAmount);

        // Receive results from server
        double monthlyPayment = fromServer.readDouble();
        double totalPayment = fromServer.readDouble();

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
