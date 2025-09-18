package diettelFiles;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEncryptionDecryption {
    private JFrame frame;
    private JTextField inputFileField;
    private JTextField outputFileField;
    private JTextField keyField;

    public FileEncryptionDecryption() {
        createGUI();
    }

    private void createGUI() {
        frame = new JFrame("File Encryption and Decryption");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        frame.add(new JLabel("Input File:"), gbc);

        inputFileField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 0;
        frame.add(inputFileField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(new JLabel("Output File:"), gbc);

        outputFileField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 1;
        frame.add(outputFileField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(new JLabel("Key:"), gbc);

        keyField = new JTextField(20);
        gbc.gridx = 1;
        gbc.gridy = 2;
        frame.add(keyField, gbc);

        JButton encryptButton = new JButton("Encrypt");
        encryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                encryptFile();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(encryptButton, gbc);

        JButton decryptButton = new JButton("Decrypt");
        decryptButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                decryptFile();
            }
        });
        gbc.gridx = 1;
        gbc.gridy = 3;
        frame.add(decryptButton, gbc);

        frame.pack();
        frame.setVisible(true);
    }

    private void encryptFile() {
        try {
            int key = Integer.parseInt(keyField.getText());
            String inputFile = inputFileField.getText();
            String outputFile = outputFileField.getText();

            Scanner scanner = new Scanner(new File(inputFile));
            FileWriter writer = new FileWriter(outputFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String encryptedLine = encrypt(line, key);
                writer.write(encryptedLine + "\n");
            }

            scanner.close();
            writer.close();
            JOptionPane.showMessageDialog(frame, "File encrypted successfully.");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(frame, "Input file not found.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error writing to output file.");
        }
    }

    private void decryptFile() {
        try {
            int key = Integer.parseInt(keyField.getText());
            String inputFile = inputFileField.getText();
            String outputFile = outputFileField.getText();

            Scanner scanner = new Scanner(new File(inputFile));
            FileWriter writer = new FileWriter(outputFile);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String decryptedLine = decrypt(line, key);
                writer.write(decryptedLine + "\n");
            }

            scanner.close();
            writer.close();
            JOptionPane.showMessageDialog(frame, "File decrypted successfully.");
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(frame, "Input file not found.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(frame, "Error writing to output file.");
        }
    }

    private String encrypt(String text, int key) {
        StringBuilder encryptedText = new StringBuilder();
        for (char c : text.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isUpperCase(c) ? 'A' : 'a';
                encryptedText.append((char) ((c - base + key) % 26 + base));
            } else {
                encryptedText.append(c);
            }
        }
        return encryptedText.toString();
    }

    private String decrypt(String text, int key) {
        return encrypt(text, 26 - key);
    }

    public static void main(String[] args) {
        new FileEncryptionDecryption();
    }
}
