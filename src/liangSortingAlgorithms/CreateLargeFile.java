package liangSortingAlgorithms;

import java.io.*;

public class CreateLargeFile {
    public static void main(String[] args) throws Exception {
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream("largeData.dat")));

        for (int i = 0; i < 800004; i++)
            output.writeInt((int) (Math.random() * 1000000));

        output.close();

        // Display first 100 numbers
        DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream("largeData.dat")));
        for (int i = 0; i < 100; i++)
            System.out.print(input.readInt() + " ");

        input.close();
    }

    private static int initializeSegments(int segmentSize, String originalFile, String f1) throws Exception {
        int[] list = new int[segmentSize];
        DataInputStream input = new DataInputStream(new BufferedInputStream(new FileInputStream(originalFile)));
        DataOutputStream output = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(f1)));
        int numberOfSegments = 0;
        while (input.available() > 0) {
            numberOfSegments++;
            int i = 0;
            for (; input.available() > 0 && i < segmentSize; i++) {
                list[i] = input.readInt();
            }
            // Sort an array list[0..i-1]
            java.util.Arrays.sort(list, 0, i);
            // Write the array to f1.dat
            for (int j = 0; j < i; j++) {
                output.writeInt(list[j]);
            }
        }

        input.close();
        output.close();
        return numberOfSegments;
    }

    private static void copyHalfToF2(int numberOfSegments, int segmentSize, DataInputStream f1, DataOutputStream f2) throws Exception {
        for (int i = 0; i < (numberOfSegments / 2) * segmentSize; i++) {
            f2.writeInt(f1.readInt());

        }
    }

    private static void mergeSegments(int numberOfSegments, int segmentSize, DataInputStream f1, DataInputStream f2, DataOutputStream f3) throws Exception {
        for (int i = 0; i < numberOfSegments; i++) {
            mergeTwoSegments(segmentSize, f1, f2, f3);
        }
        // If f1 has one extra segment, copy it to f3
        while (f1.available() > 0) {
            f3.writeInt(f1.readInt());
        }
    }

    private static void mergeTwoSegments(int segmentSize, DataInputStream f1, DataInputStream f2, DataOutputStream f3) throws Exception {
        int intFromF1 = f1.readInt();
        int intFromF2 = f2.readInt();
        int f1Count = 1;
        int f2Count = 1;
        while (true) {
            if (intFromF1 < intFromF2) {
                f3.writeInt(intFromF1);
                if (f1.available() == 0 || f1Count++ >= segmentSize) {
                    f3.writeInt(intFromF2);
                    break;
                } else {
                    intFromF1 = f1.readInt();
                }
            } else {
                f3.writeInt(intFromF2);
                if (f2.available() == 0 || f2Count++ >= segmentSize) {
                    f3.writeInt(intFromF1);
                    break;
                } else {
                    intFromF2 = f2.readInt();
                }
            }
        }

        while (f1.available() > 0 && f1Count++ < segmentSize) {
            f3.writeInt(f1.readInt());
        }

        while (f2.available() > 0 && f2Count++ < segmentSize) {
            f3.writeInt(f2.readInt());
        }
    }
}