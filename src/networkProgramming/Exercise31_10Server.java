package networkProgramming;
import java.io.*;
import java.net.*;
import java.util.*;
public class Exercise31_10Server {
    private ServerSocket serverSocket;
    private ArrayList<HandleClient> clients;

    public Exercise31_10Server() {
        clients = new ArrayList<>();

        try {
            serverSocket = new ServerSocket(8000);
            System.out.println("Server started. Waiting for clients...");

            while (true) {
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                HandleClient client = new HandleClient(socket);
                clients.add(client);
                client.start();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private class HandleClient extends Thread {
        private Socket socket;
        private DataInputStream inputFromClient;
        private DataOutputStream outputToClient;

        public HandleClient(Socket socket) {
            this.socket = socket;

            try {
                inputFromClient = new DataInputStream(socket.getInputStream());
                outputToClient = new DataOutputStream(socket.getOutputStream());
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }

        @Override
        public void run() {
            try {
                while (true) {
                    String message = inputFromClient.readUTF();
                    System.out.println("Received from client: " + message);

                    // Broadcast the message to all clients
                    for (HandleClient client : clients) {
                        if (client != this) {
                            client.outputToClient.writeUTF(message);
                        }
                    }
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Exercise31_10Server();
    }
}


