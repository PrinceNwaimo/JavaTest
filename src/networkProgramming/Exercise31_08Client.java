package networkProgramming;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;


public class Exercise31_08Client {
    public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException {
        // Create a socket
        Socket socket = new Socket("localhost", 8000);

        // Create input and output streams
        ObjectInputStream fromServer = new ObjectInputStream(socket.getInputStream());
        ObjectOutputStream toServer = new ObjectOutputStream(socket.getOutputStream());

        // Receive the prime numbers from the server
        ArrayList<Long> primeNumbers = (ArrayList<Long>) fromServer.readObject();

        // Display the prime numbers
        System.out.println("Last 100 Prime Numbers:");
        for (Long primeNumber : primeNumbers) {
            System.out.println(primeNumber);
        }

        // Close streams and socket
        fromServer.close();
        toServer.close();
        socket.close();
    }
}

