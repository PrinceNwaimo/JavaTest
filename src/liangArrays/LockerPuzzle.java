package liangArrays;

public class LockerPuzzle {
    public static void main(String[] args) {
        boolean[] lockers = new boolean[101]; // Ignore index 0 for simplicity

        // Initially, all lockers are closed
        for (int i = 1; i <= 100; i++) {
            lockers[i] = false;
        }

        // Students change lockers
        for (int student = 1; student <= 100; student++) {
            for (int locker = student; locker <= 100; locker += student) {
                lockers[locker] = !lockers[locker];
            }
        }

        // Print open lockers
        System.out.println("Open lockers: ");
        for (int i = 1; i <= 100; i++) {
            if (lockers[i]) {
                System.out.print(i + " ");
            }
        }
    }

}
