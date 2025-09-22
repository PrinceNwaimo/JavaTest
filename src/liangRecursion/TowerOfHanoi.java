package liangRecursion;

public class TowerOfHanoi {
    private static int count = 0;

    public static void main(String[] args) {
        int n = 3; // Number of disks
        System.out.println("Moves needed to move " + n + " disks from tower A to tower B:");
        moveDisks(n, 'A', 'B', 'C');
        System.out.println("Number of moves: " + count);
    }

    public static void moveDisks(int n, char fromTower, char toTower, char tempTower) {
        if (n == 1) {
            System.out.println("Move disk 1 from tower " + fromTower + " to tower " + toTower);
            count++; // Increment the count when a disk is moved
        } else {
            moveDisks(n - 1, fromTower, tempTower, toTower);
            System.out.println("Move disk " + n + " from tower " + fromTower + " to tower " + toTower);
            count++; // Increment the count when a disk is moved
            moveDisks(n - 1, tempTower, toTower, fromTower);
        }
    }
}
