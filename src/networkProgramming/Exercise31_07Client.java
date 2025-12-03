package networkProgramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Exercise31_07Client {
    public static void main(String[] args) throws UnknownHostException, IOException {
        // Create a socket
        Socket socket = new Socket("localhost", 8000);

        // Create input and output streams
        DataInputStream fromServer = new DataInputStream(socket.getInputStream());
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());

        // Receive the prime numbers from the server
        int length = fromServer.readInt();
        long[] primeNumbers = new long[length];
        for (int i = 0; i < length; i++) {
            primeNumbers[i] = fromServer.readLong();
        }

        // Display the prime numbers
        System.out.println("Last 100 Prime Numbers:");
        for (long primeNumber : primeNumbers) {
            System.out.println(primeNumber);
        }

        // Close streams and socket
        fromServer.close();
        toServer.close();
        socket.close();
    }
}