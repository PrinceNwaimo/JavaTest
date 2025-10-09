package diettelStreams;
import java.io.*;
import java.util.*;

public class PhoneDirectorySorter {
    public static void main(String[] args) {
        String inputFile = "input.txt";
        String outputFileByNumber = "phone_directory_by_number.txt";
        String outputFileByName = "phone_directory_by_name.txt";

        // Read records from input file and store in a set to remove duplicates
        Set<PhoneRecord> records = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\s+");
                if (parts.length == 3) {
                    records.add(new PhoneRecord(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading input file: " + e.getMessage());
            return;
        }
        // Write records to output files
        try (BufferedWriter writerByNumber = new BufferedWriter(new FileWriter(outputFileByNumber));
             BufferedWriter writerByName = new BufferedWriter(new FileWriter(outputFileByName))) {
            // Sort records by phone number and write to output file
            records.stream()
                    .sorted(Comparator.comparing(PhoneRecord::getPhoneNumber))
                    .forEach(record -> {
                        try {
                            writerByNumber.write(record.toStringByNumber());
                            writerByNumber.newLine();
                        } catch (IOException e) {
                            System.out.println("Error writing to output file: " + e.getMessage());
                        }
                    });

            // Sort records by name and write to output file
            records.stream()
                    .sorted(Comparator.comparing(PhoneRecord::getLastName)
                            .thenComparing(PhoneRecord::getFirstName))
                    .forEach(record -> {
                        try {
                            writerByName.write(record.toStringByName());
                            writerByName.newLine();
                        } catch (IOException e) {
                            System.out.println("Error writing to output file: " + e.getMessage());
                        }
                    });
        } catch (IOException e) {
            System.out.println("Error writing to output file: " + e.getMessage());
        }

    }

    static class PhoneRecord {
        private String firstName;
        private String lastName;
        private String phoneNumber;

        public PhoneRecord(String firstName, String lastName, String phoneNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.phoneNumber = phoneNumber;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public String toStringByNumber() {
            return firstName + " " + lastName + " " + phoneNumber;
        }

        public String toStringByName() {
            return lastName + ", " + firstName + " " + phoneNumber;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            PhoneRecord that = (PhoneRecord) o;
            return Objects.equals(firstName, that.firstName) &&
                    Objects.equals(lastName, that.lastName) &&
                    Objects.equals(phoneNumber, that.phoneNumber);
        }

        @Override
        public int hashCode() {
            return Objects.hash(firstName, lastName, phoneNumber);
        }
}
}