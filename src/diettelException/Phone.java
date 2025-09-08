package diettelException;

public class Phone {
    private String name;
    private String serialNumber;

    public Phone(String name, String serialNumber) throws ValidationException {
        if (name.isEmpty() || serialNumber.isEmpty()) {
            throw new ValidationException("Name and serial number cannot be empty");
        }
        if (serialNumber.length() != 16 || !serialNumber.matches("\\d+")) {
            throw new ValidationException("Serial number must be exactly 16 digits");
        }
        this.name = name;
        this.serialNumber = serialNumber;
    }

    public String getName() {
        return name;
    }

    public String getSerialNumber() {
        return serialNumber;
    }
}
