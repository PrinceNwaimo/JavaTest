package networkProgramming;
import java.io.*;
import java.net.*;

public class CountServer {
private static final String FILE_NAME = "visitor_count.dat";
private static int visitorCount;

    public static void main(String[] args) throws IOException {
        // Initialize visitor count
        try (RandomAccessFile file = new RandomAccessFile(FILE_NAME, "rw")) {
            if (file.length() == 0) {
                visitorCount = 0;
            } else {
                visitorCount = file.readInt();
            }
        }

        // Create a server socket
        ServerSocket serverSocket = new ServerSocket(8000);
        System.out.println("Server started");

        while (true) {
            // Listen for a connection request
            Socket socket = serverSocket.accept();

            // Increment visitor count
            visitorCount++;

            // Update visitor count in file
            try (RandomAccessFile file = new RandomAccessFile(FILE_NAME, "rw")) {
                file.writeInt(visitorCount);
            }

            // Create a new thread for the client
            Thread clientThread = new Thread(new ClientHandler2(socket, visitorCount));
            clientThread.start();
        }
    }
}

class ClientHandler2 implements Runnable {
    private Socket socket;
    private int visitorCount;

    public ClientHandler2(Socket socket, int visitorCount) {
        this.socket = socket;
        this.visitorCount = visitorCount;
    }

    @Override
    public void run() {
        try {
            // Create output stream
            DataOutputStream outputToClient = new DataOutputStream(socket.getOutputStream());

            // Send visitor count to client
            outputToClient.writeInt(visitorCount);

            // Close streams and socket
            outputToClient.close();
            socket.close();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}




