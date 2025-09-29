package liangBigONotation;

import java.io.IOException;
import java.io.RandomAccessFile;

public class Last100PrimeNumbers {
    public static void main(String[] args) throws IOException {
        try (RandomAccessFile file = new RandomAccessFile("PrimeNumbers.dat", "r")) {
            long fileSize = file.length();
            int primeCount = (int) (fileSize / 8); // Each long is 8 bytes
            int skipCount = primeCount - 100;

            if (skipCount > 0) {
                file.seek(skipCount * 8);
            }

            for (int i = 0; i < Math.min(100, primeCount); i++) {
                System.out.println(file.readLong());
            }
        }
    }
}
