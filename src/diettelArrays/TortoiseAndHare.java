package diettelArrays;

import java.util.Random;

public class TortoiseAndHare {
    public static void main(String[] args) {
        int tortoisePosition = 1;
        int harePosition = 1;
        Random random = new Random();

        System.out.println("BANG !!!!! AND THEY'RE OFF !!!!!");

        while (tortoisePosition < 70 && harePosition < 70) {
            int tortoiseMove = random.nextInt(10) + 1;
            int hareMove = random.nextInt(10) + 1;

            tortoisePosition += getTortoiseMove(tortoiseMove);
            harePosition += getHareMove(hareMove);

            tortoisePosition = Math.max(tortoisePosition, 1);
            harePosition = Math.max(harePosition, 1);

            printPositions(tortoisePosition, harePosition);

            if (tortoisePosition >= 70 && harePosition >= 70) {
                System.out.println("It's a tie");
                break;
            } else if (tortoisePosition >= 70) {
                System.out.println("TORTOISE WINS!!! YAY!!!");
                break;
            } else if (harePosition >= 70) {
                System.out.println("Hare wins. Yuch.");
                break;
            }
        }
    }

    private static int getTortoiseMove(int move) {
        if (move <= 5) {
            return 3; // Fast plod
        } else if (move <= 7) {
            return -6; // Slip
        } else {
            return 1; // Slow plod
        }
    }

    private static int getHareMove(int move) {
        if (move <= 2) {
            return 0; // Sleep
        } else if (move <= 4) {
            return 9; // Big hop
        } else if (move <= 5) {
            return -12; // Big slip
        } else if (move <= 8) {
            return 1; // Small hop
        } else {
            return -2; // Small slip
        }
    }

    private static void printPositions(int tortoisePosition, int harePosition) {
        for (int i = 1; i <= 70; i++) {
            if (i == tortoisePosition && i == harePosition) {
                System.out.print("OUCH!!!");
            } else if (i == tortoisePosition) {
                System.out.print("T");
            } else if (i == harePosition) {
                System.out.print("H");
            } else {
                System.out.print(" ");
            }
        }
        System.out.println();
    }

}
