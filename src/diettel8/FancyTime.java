package diettel8;

public class FancyTime {
    private int hour;
    private int minute;
    private int second;

    public FancyTime(int hour, int minute, int second, String meridiem) {
        if (meridiem.equalsIgnoreCase("a.m.")) {
            if (hour == 12) {
                this.hour = 0;
            } else {
                this.hour = hour;
            }
        } else if (meridiem.equalsIgnoreCase("p.m.")) {
            if (hour == 12) {
                this.hour = hour;
            } else {
                this.hour = hour + 12;
            }
        }

        this.minute = minute;
        this.second = second;
    }

    public FancyTime(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }

    public FancyTime(int hour, int minute) {
        this(hour, minute, 0);
    }

    public void displayTime(int format) {
        switch (format) {
            case 1:
                if (hour == 0) {
                    System.out.printf("%02d:%02d:%02d a.m.%n", 12, minute, second);
                } else if (hour < 12) {
                    System.out.printf("%02d:%02d:%02d a.m.%n", hour, minute, second);
                } else if (hour == 12) {
                    System.out.printf("%02d:%02d:%02d p.m.%n", hour, minute, second);
                } else {
                    System.out.printf("%02d:%02d:%02d p.m.%n", hour - 12, minute, second);
                }
                break;
            case 2:
                System.out.printf("%02d:%02d:%02d%n", hour, minute, second);
                break;
            case 3:
                System.out.printf("%02d:%02d%n", hour, minute);
                break;
            default:
                System.out.println("Invalid format");
        }
    }
}
