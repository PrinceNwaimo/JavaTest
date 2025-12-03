package networkProgramming;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

public class Exercise31_06Server {
    private static ArrayList<StudentAddress> addresses = new ArrayList<>();
    private static int currentIndex = 0;
    private static final int MAX_CONNECTIONS = 2;

    public static void main(String[] args) throws IOException {
        // Initialize addresses
        addresses.add(new StudentAddress("John Doe", "123 Main St", "Anytown", "CA", "12345"));
        addresses.add(new StudentAddress("Jane Doe", "456 Elm St", "Othertown", "NY", "67890"));

        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started");

        int connectionCount = 0;

        while (true) {
            // Listen for a connection request
            Socket socket = serverSocket.accept();

            if (connectionCount < MAX_CONNECTIONS) {
                connectionCount++;

                // Create a new thread for the client
                Thread clientThread = new Thread(new ClientHandler(socket));
                clientThread.start();
            } else {
                // Send error message to client
                DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());
                outputToClient.writeUTF("Maximum connections reached. Please try later.");
                outputToClient.close();
                socket.close();
            }
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

                while (true) {
                    // Receive request from client
                    String request = (String) inputFromClient.readObject();

                    if (request.equals("FIRST")) {
                        currentIndex = 0;
                        outputToClient.writeObject(addresses.get(currentIndex));
                    } else if (request.equals("NEXT")) {
                        if (currentIndex < addresses.size() - 1) {
                            currentIndex++;
                            outputToClient.writeObject(addresses.get(currentIndex));
                        } else {
                            outputToClient.writeObject(null);
                        }
                    } else if (request.equals("PREVIOUS")) {
                        if (currentIndex > 0) {
                            currentIndex--;
                            outputToClient.writeObject(addresses.get(currentIndex));
                        } else {
                            outputToClient.writeObject(null);
                        }
                    } else if (request.equals("LAST")) {
                        currentIndex = addresses.size() - 1;
                        outputToClient.writeObject(addresses.get(currentIndex));
                    } else if (request.equals("ADD")) {
                        StudentAddress address = (StudentAddress) inputFromClient.readObject();
                        addresses.add(address);
                        outputToClient.writeObject("Address added successfully.");
                    }
                }
            } catch (IOException | ClassNotFoundException e) {
                System.err.println(e.getMessage());
            } finally {
                try {
                    socket.close();
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }
            }
        }
    }
}
