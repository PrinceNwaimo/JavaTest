package leetCodeProblems;
import java.lang.Math;

public class BulbSwitcher {
    public int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        BulbSwitcher bs = new BulbSwitcher();

        // Test cases
        System.out.println("n=0: " + bs.bulbSwitch(0));    // 0
        System.out.println("n=1: " + bs.bulbSwitch(1));    // 1
        System.out.println("n=2: " + bs.bulbSwitch(2));    // 1
        System.out.println("n=3: " + bs.bulbSwitch(3));    // 1
        System.out.println("n=4: " + bs.bulbSwitch(4));    // 2
        System.out.println("n=5: " + bs.bulbSwitch(5));    // 2
        System.out.println("n=6: " + bs.bulbSwitch(6));    // 2
        System.out.println("n=7: " + bs.bulbSwitch(7));    // 2
        System.out.println("n=8: " + bs.bulbSwitch(8));    // 2
        System.out.println("n=9: " + bs.bulbSwitch(9));    // 3
        System.out.println("n=10: " + bs.bulbSwitch(10));  // 3
        System.out.println("n=100: " + bs.bulbSwitch(100)); // 10
        System.out.println("n=1000: " + bs.bulbSwitch(1000)); // 31
        System.out.println("n=10000: " + bs.bulbSwitch(10000)); // 100

        // Additional test cases with formatting
        System.out.println("\n=== Pattern of results ===");
        for (int n = 1; n <= 20; n++) {
            System.out.printf("n=%2d -> %d bulbs on\n", n, bs.bulbSwitch(n));
        }
    }
}
