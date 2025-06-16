package diettel6;

import java.security.SecureRandom;

public class RollDice {
    public static void main(String[] args) {
        SecureRandom randomNumbers = new SecureRandom();

        int frequency1 = 0;
        int frequency2 = 0;
        int frequency3 = 0;
        int frequency4 = 0;
        int frequency5 = 0;
        int frequency6 = 0;

        for (int roll = 1; roll <= 60_000_000 ; roll++) {
            int face = 1 + randomNumbers.nextInt(6);

            switch(face){
                case 1:
                    ++frequency1; // increment the 1s counter
                    break;
                case 2:
                    ++frequency2; // increment the 2s counter
                    break;
                case 3:
                    ++frequency3; // increment the 3s counter
                    break;
                case 4:
                    ++frequency4; // increment the 4s counter
                    break;
                case 5:
                    ++frequency5; // increment the 5s counter
                    break;
                case 6:
                    ++frequency6; // increment the 6s counter
                    break;
            }

        }
        System.out.println("Face\tFrequency");
        System.out.printf("1\t%d%n2\t%d%n3\t%d%n4\t%d%n5\t%d%n6\t%d%n", frequency1, frequency2, frequency3, frequency4, frequency5, frequency6);
    }
}
