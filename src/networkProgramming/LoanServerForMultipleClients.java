package networkProgramming;
import java.io.*;
import java.net.*;
import java.text.DecimalFormat;

public class LoanServerForMultipleClients {
public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started");

        while (true) {
            // Listen for a connection request
            Socket socket = serverSocket.accept();

            // Create a new thread for the client
            Thread clientThread = new Thread(new ClientHandler(socket));
            clientThread.start();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            // Create input and output streams
            DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

            // Receive data from client
            double annualInterestRate = inputFromClient.readDouble();
            int numberOfYears = inputFromClient.readInt();
            double loanAmount = inputFromClient.readDouble();

            // Compute monthly payment and total payment
            double monthlyInterestRate = annualInterestRate / 1200;
            int numberOfPayments = numberOfYears * 12;
            double monthlyPayment = loanAmount * monthlyInterestRate / (1 - 1 / Math.pow(1 + monthlyInterestRate, numberOfPayments));
            double totalPayment = monthlyPayment * numberOfPayments;

            // Send results back to client
            outputToClient.writeDouble(monthlyPayment);
            outputToClient.writeDouble(totalPayment);

            // Close streams and socket
            inputFromClient.close();
            outputToClient.close();
            socket.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}




