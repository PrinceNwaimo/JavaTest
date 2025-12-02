package networkProgramming;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;
import java.net.*;
import java.util.Scanner;
public class CountClient {
    public static void main(String[] args) throws UnknownHostException, IOException {
            // Create a socket
            Socket socket = new Socket("localhost", 8000);

            // Create input stream
            DataInputStream fromServer = new DataInputStream(socket.getInputStream());

            // Receive visitor count from server
            int visitorCount = fromServer.readInt();

            // Display message
            System.out.println("You are visitor number " + visitorCount);

            // Close streams and socket
            fromServer.close();
            socket.close();
        }
    }

