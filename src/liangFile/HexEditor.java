package liangFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class HexEditor extends JFrame {
    private JTextField fileNameField;
    private JTextArea hexTextArea;
    private JButton saveButton;

    public HexEditor() {
        setLayout(new BorderLayout());

        // North panel for file name field
        JPanel northPanel = new JPanel();
        northPanel.add(new JLabel("File Name:"));
        fileNameField = new JTextField(20);
        fileNameField.addActionListener(new FileNameListener());
        northPanel.add(fileNameField);
        add(northPanel, BorderLayout.NORTH);

        // Center panel for hex text area
        hexTextArea = new JTextArea(20, 40);
        add(new JScrollPane(hexTextArea), BorderLayout.CENTER);

        // South panel for save button
        JPanel southPanel = new JPanel();
        saveButton = new JButton("Save");
        saveButton.addActionListener(new SaveButtonListener());
        saveButton.setEnabled(false);
        southPanel.add(saveButton);
        add(southPanel, BorderLayout.SOUTH);

        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class FileNameListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String filename = fileNameField.getText();
            try (FileInputStream fis = new FileInputStream(filename)) {
                StringBuilder hex = new StringBuilder();
                int byteRead;
                while ((byteRead = fis.read()) != -1) {
                    hex.append(String.format("%02X ", byteRead));
                }
                hexTextArea.setText(hex.toString());
                saveButton.setEnabled(true);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
    }

    private class SaveButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String filename = fileNameField.getText();
            String[] hexStrings = hexTextArea.getText().split("\\s+");
            try (FileOutputStream fos = new FileOutputStream(filename)) {
                for (String hexString : hexStrings) {
                    if (!hexString.isEmpty()) {
                        fos.write(Integer.parseInt(hexString, 16));
                    }
                }
                JOptionPane.showMessageDialog(null, "File saved successfully");
            } catch (IOException | NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        new HexEditor();
    }
}
