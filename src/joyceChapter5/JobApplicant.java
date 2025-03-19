package joyceChapter5;

public class JobApplicant {
    private String name;
    private String phoneNumber;
    private boolean wordProcessing;
    private boolean spreadsheets;
    private boolean databases;
    private boolean graphics;

    public JobApplicant(String name, String phoneNumber, boolean wordProcessing, boolean spreadsheets, boolean databases, boolean graphics) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.wordProcessing = wordProcessing;
        this.spreadsheets = spreadsheets;
        this.databases = databases;
        this.graphics = graphics;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isWordProcessing() {
        return wordProcessing;
    }

    public boolean isSpreadsheets() {
        return spreadsheets;
    }

    public boolean isDatabases() {
        return databases;
    }

    public boolean isGraphics() {
        return graphics;
    }

}
