package liangChapter6;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ShowCurrentDateTime {
    public static void main(String[] args) {
        LocalDateTime currentDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);

        System.out.println("Current date and time: " + formattedDateTime);
    }

}
