package diettelException;

public class PhoneTest {
    public static void main(String[] args) {
        try {
            Phone phone = new Phone("iPhone", "1234567890123456");
            System.out.println("Phone created successfully");
        } catch (ValidationException e) {
            System.out.println("Validation error: " + e.getMessage());
        }

        try {
            Phone phone = new Phone("", "1234567890123456");
            System.out.println("Phone created successfully");
        } catch (ValidationException e) {
            System.out.println("Validation error: " + e.getMessage());
        }

        try {
            Phone phone = new Phone("iPhone", "123456789012345");
            System.out.println("Phone created successfully");
        } catch (ValidationException e) {
            System.out.println("Validation error: " + e.getMessage());
        }
    }
}
