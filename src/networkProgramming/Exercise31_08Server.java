package networkProgramming;
import java.io.*;
import java.net.*;
import java.util.*;

public class Exercise31_08Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
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

    static class ClientHandler implements Runnable {
        private Socket socket;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                // Create input and output streams
                ObjectInputStream inputFromClient = new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream outputToClient = new ObjectOutputStream(socket.getOutputStream());

                // Read the last 100 prime numbers from file
                ArrayList<Long> primeNumbers = readLast100PrimeNumbers();

                // Send the primeObjectNumbers);

                // Send the prime numbers to the client
                outputToClient.writeObject(primeNumbers);

                // Close streams and socket
                inputFromClient.close();
                outputToClient.close();
                socket.close();
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

        private ArrayList<Long> readLast100PrimeNumbers() throws IOException {
            RandomAccessFile file = new RandomAccessFile("PrimeNumbers.dat", "r");
            long fileSize = file.length() / 8;
            ArrayList<Long> primeNumbers = new ArrayList<>();

            file.seek(Math.max(0, fileSize - 100) * 8);
            for (int i = 0; i < Math.min(fileSize, 100); i++) {
                primeNumbers.add(file.readLong());
            }

            file.close();
            return primeNumbers;
        }
    }
}




