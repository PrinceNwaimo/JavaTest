package joyceFiles;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GameWithPassword {
    private static Map<String, String> users = new HashMap<>();

    public static void main(String[] args) {
        readUsers();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter user ID: ");
        String id = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (authenticateUser(id, password)) {
            System.out.println("Login successful!");
            // Play game here
        } else {
            System.out.println("Invalid user ID or password.");
        }
    }

    private static void readUsers() {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                users.put(parts[0], parts[1]);
            }
        } catch (IOException e) {
            System.out.println("Error reading users.");
        }
    }

    private static boolean authenticateUser(String id, String password) {
        return users.containsKey(id) && users.get(id).equals(password);
    }
}
