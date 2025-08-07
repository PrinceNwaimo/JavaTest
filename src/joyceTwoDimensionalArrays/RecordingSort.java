package joyceTwoDimensionalArrays;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class RecordingSort {
    public static void main(String[] args) {
        Recording[] recordings = new Recording[5];
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < 5; i++) {
            recordings[i] = new Recording();
            System.out.println("Enter details for Recording " + (i + 1));
            System.out.print("Title: ");
            recordings[i].setTitle(scanner.nextLine());
            System.out.print("Artist: ");
            recordings[i].setArtist(scanner.nextLine());
            System.out.print("Playing Time (in seconds): ");
            recordings[i].setPlayingTime(scanner.nextInt());
            scanner.nextLine(); // Consume newline left-over
        }

        System.out.println("Enter the field to sort by:");
        System.out.println("1. Title");
        System.out.println("2. Artist");
        System.out.println("3. Playing Time");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline left-over

        switch (choice) {
            case 1:
                Arrays.sort(recordings, Comparator.comparing(Recording::getTitle));
                break;
            case 2:
                Arrays.sort(recordings, Comparator.comparing(Recording::getArtist));
                break;
            case 3:
                Arrays.sort(recordings, Comparator.comparingInt(Recording::getPlayingTime));
                break;
            default:
                System.out.println("Invalid choice");
                return;
        }

        System.out.println("Sorted Recordings:");
        for (Recording recording : recordings) {
            System.out.println(recording);
        }
    }

}
