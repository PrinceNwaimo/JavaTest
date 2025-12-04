package networkProgramming;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Exercise31_09Client extends JFrame {
    private JTextArea taClient;
    private JTextField tfInput;
    private Socket socket;
    private DataInputStream inputFromServer;
    private DataOutputStream outputToServer;

    public Exercise31_09Client() {
        // Create UI components
        taClient = new JTextArea(10, 20);
        taClient.setEditable(false);
        tfInput = new JTextField(20);

        // Add action listener to input text field
        tfInput.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Send input to server
                    outputToServer.writeUTF(tfInput.getText());
                    outputToServer.flush();

                    // Display input in client text area
                    taClient.append("Client: " + tfInput.getText() + "\n");
                    tfInput.setText("");
                } catch (IOException ex) {
                    System.err.println(ex.getMessage());
                }
            }
        });

        // Create panel and add components
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.add(new JScrollPane(taClient), BorderLayout.CENTER);
        panel.add(tfInput, BorderLayout.SOUTH);

        // Add panel to frame
        add(panel, BorderLayout.CENTER);

        // Set up frame
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Create socket and connect to server
        try {
            socket = new Socket("localhost", 8000);
            inputFromServer = new DataInputStream(socket.getInputStream());
            outputToServer = new DataOutputStream(socket.getOutputStream());

            // Start receiving messages from server
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
                    // Receive message from server
                    String message = inputFromServer.readUTF();

                    // Display message in client text area
                    taClient.append("Server: " + message + "\n");
                }
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new Exercise31_09Client();
    }
}


