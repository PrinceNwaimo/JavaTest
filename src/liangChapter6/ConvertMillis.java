package liangChapter6;

public class ConvertMillis {
    public static void main(String[] args) {
        System.out.println(convertMillis(5500)); // Output: 00:00:05
        System.out.println(convertMillis(100000)); // Output: 00:01:40
        System.out.println(convertMillis(555550000)); // Output: 154:19:10
    }

    public static String convertMillis(long millis) {
        long totalSeconds = millis / 1000;
        long hours = totalSeconds / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;

        return String.format("%02d:%02d:%02d", hours, minutes, seconds);
    }

}
