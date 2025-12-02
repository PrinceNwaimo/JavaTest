package networkProgramming;
import java.io.*;
import java.net.*;
public class BMIServer {
public static void main(String[] args) throws IOException {
        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started");

        while (true) {
            // Listen for a connection request
            Socket socket = serverSocket.accept();

            // Create input and output streams
            DataInputStream inputFromClient = new DataInputStream(socket.getInputStream());
            DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

            // Receive data from client
            double weight = inputFromClient.readDouble();
            double height = inputFromClient.readDouble();

            // Compute BMI
            double bmi = weight / Math.pow(height, 2);

            // Determine BMI category
            String category;
            if (bmi < 18.5) {
                category = "Underweight";
            } else if (bmi < 25) {
                category = "Normal";
            } else if (bmi < 30) {
                category = "Overweight";
            } else {
                category = "Obese";
            }

            // Send result back to client
            outputToClient.writeUTF(String.format("BMI: %.2f (%s)", bmi, category));

            // Close streams and socket
            inputFromClient.close();
            outputToClient.close();
            socket.close();
        }
    }
}




