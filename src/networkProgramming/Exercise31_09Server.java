package networkProgramming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Exercise31_09Server extends JFrame {
    private JTextArea taServer;
    private JTextField tfInput;
    private ServerSocket serverSocket;
    private Socket socket;
    private DataInputStream inputFromClient;
    private DataOutputStream outputToClient;

    public Exercise31_09Server() {
        // Create UI components
        taServer = new JTextArea(10, 20);
        taServer.setEditable(false);
        tfInput = new JTextField(20);

        // Add action listener to input text field
        tfInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Send input to client
                    outputToClient.writeUTF(tfInput.getText());
                    outputToClient.flush();

                    // Display input in server text area
                    taServer.append("Server: " + tfInput.getText() + "\n");
                    tfInput.setText("");
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        });

        // Create panel and add components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(taServer), BorderLayout.CENTER);
        panel.add(tfInput, BorderLayout.SOUTH);

        // Add panel to frame
        add(panel, BorderLayout.CENTER);

        // Set up frame
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Create server socket and start listening
        try {
            serverSocket = new ServerSocket(8000);
            socket = serverSocket.accept();
            inputFromClient = new DataInputStream(socket.getInputStream());
            outputToClient = new DataOutputStream(socket.getOutputStream());

            // Start receiving messages from client
            Thread thread = new Thread(new ReceiveMessage());
            thread.start();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private class ReceiveMessage implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    // Receive message from client
                    String message = inputFromClient.readUTF();

                    // Display message in server text area
                    taServer.append("Client: " + message + "\n");
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Exercise31_09Server();
    }
}
