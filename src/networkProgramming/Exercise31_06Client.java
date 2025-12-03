package networkProgramming;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;

public class Exercise31_06Client extends JFrame {
    private JTextField nameField;
    private JTextField streetField;
    private JTextField cityField;
    private JTextField stateField;
    private JTextField zipField;

    private ObjectOutputStream toServer;
    private ObjectInputStream fromServer;

    public Exercise31_06Client() throws UnknownHostException, IOException {
        // Create UI components
        nameField = new JTextField(20);
        streetField = new JTextField(20);
        cityField = new JTextField(20);
        stateField = new JTextField(20);
        zipField = new JTextField(20);

        JButton firstButton = new JButton("First");
        JButton nextButton = new JButton("Next");
        JButton previousButton = new JButton("Previous");
        JButton lastButton = new JButton("Last");
        JButton addButton = new JButton("Add");

        // Add action listeners
        firstButton.addActionListener(new ButtonListener("FIRST"));
        nextButton.addActionListener(new ButtonListener("NEXT"));
        previousButton.addActionListener(new ButtonListener("PREVIOUS"));
        lastButton.addActionListener(new ButtonListener("LAST"));
        addButton.addActionListener(new ButtonListener("ADD"));

        // Create panel and add components
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 2));
        panel.add(new JLabel("Name"));
        panel.add(nameField);
        panel.add(new JLabel("Street"));
        panel.add(streetField);
        panel.add(new JLabel("City"));
        panel.add(cityField);
        panel.add(new JLabel("State"));
        panel.add(stateField);
        panel.add(new JLabel("Zip"));
        panel.add(zipField);
        panel.add(firstButton);
        panel.add(nextButton);
        panel.add(previousButton);
        panel.add(lastButton);
        panel.add(addButton);

        // Add panel to frame
        add(panel, BorderLayout.CENTER);

        // Create socket and streams
        Socket socket = new Socket("localhost", 8000);
        toServer = new ObjectOutputStream(socket.getOutputStream());
        fromServer = new ObjectInputStream(socket.getInputStream());

        // Set up frame
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class ButtonListener implements ActionListener {
        private String request;

        public ButtonListener(String request) {
            this.request = request;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                if (request.equals("ADD")) {
                    StudentAddress address = new StudentAddress(nameField.getText(), streetField.getText(), cityField.getText(), stateField.getText(), zipField.getText());
                    toServer.writeObject(request);
                    toServer.writeObject(address);
                    String response = (String) fromServer.readObject();
                    JOptionPane.showMessageDialog(null, response);
                } else {
                    toServer.writeObject(request);
                    StudentAddress address = (StudentAddress) fromServer.readObject();
                    if (address != null) {
                        nameField.setText(address.getName());
                        streetField.setText(address.getStreet());
                        cityField.setText(address.getCity());
                        stateField.setText(address.getState());
                        zipField.setText(address.getZip());
                    } else {
                        JOptionPane.showMessageDialog(null, "No more records.");
                    }
                }
            } catch (IOException | ClassNotFoundException ex) {
                System.err.println(ex.getMessage());
            }
        }
    }

    public static void main(String[] args) throws UnknownHostException, IOException {
        new Exercise31_06Client();
    }
}