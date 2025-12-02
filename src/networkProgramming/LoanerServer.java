package networkProgramming;
import java.io.*;
import java.net.*;
public class LoanerServer {
public static void main(String[] args) throws IOException, ClassNotFoundException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started");

        while (true) {
            // Listen for a connection request
            Socket socket = serverSocket.accept();

            // Create input and output streams
            ObjectInputStream inputFromClient = new ObjectInputStream(socket.getInputStream());
            ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());

            // Receive loan object from client
            Loaner loan = (Loaner) inputFromClient.readObject();

            // Compute monthly payment and total payment
            double monthlyInterestRate = loan.getAnnualInterestRate() / 1200;
            int numberOfPayments = loan.getNumberOfYears() * 12;
            double monthlyPayment = loan.getLoanAmount() * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfPayments));
            double totalPayment = monthlyPayment * numberOfPayments;

            // Send results back to client
            outputToClient.writeObject(monthlyPayment);
            outputToClient.writeObject(totalPayment);

            // Close streams and socket
            inputFromClient.close();
            outputToClient.close();
            socket.close();
        }
    }
}