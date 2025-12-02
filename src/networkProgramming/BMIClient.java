package networkProgramming;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class BMIClient {
public static void main(String[] args) throws UnknownHostException, IOException {
        // Create a scanner
        Scanner input = new Scanner(System.in);

        // Get user input
        System.out.print("Enter weight in kilograms: ");
        double weight = input.nextDouble();
        System.out.print("Enter height in meters: ");
        double height = input.nextDouble();

        // Create a socket
        Socket socket = new Socket("localhost", 8000);

        // Create output and input streams
        DataOutputStream toServer = new DataOutputStream(socket.getOutputStream());
        DataInputStream fromServer = new DataInputStream(socket.getInputStream());

        // Send data to server
        toServer.writeDouble(weight);
        toServer.writeDouble(height);

        // Receive result from server
        String result = fromServer.readUTF();

        // Display result
        System.out.println(result);

        // Close streams and socket
        toServer.close();
        fromServer.close();
        socket.close();
    }
}