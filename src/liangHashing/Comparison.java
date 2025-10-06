package liangHashing;

import liangImplementingDSA.MyArrayList;

import java.util.Random;

public class Comparison {
    public static void main(String[] args) {
        MyArrayList<Double> list = new MyArrayList<>();
        MyHashSet<Double> set = new MyHashSet<>();

        // Generate 1000000 random double values between 0 and 999999
        Random random = new Random();
        for (int i = 0; i < 1000000; i++) {
            double value = random.nextDouble() * 1000000;
            list.add(value);
            set.add(value);
        }

        // Generate a list of 1000000 random double values between 0 and 1999999
        MyArrayList<Double> testList = new MyArrayList<>();
        for (int i = 0; i < 1000000; i++) {
            double value = random.nextDouble() * 2000000;
            testList.add(value);
        }

        // Test if each number in the test list is in the array list and hash set
        long startTime = System.currentTimeMillis();
        for (double value : testList) {
            list.contains(value);
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time for array list: " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        for (double value : testList) {
            set.contains(value);
        }
        endTime = System.currentTimeMillis();
        System.out.println("Time for hash set: " + (endTime - startTime) + " milliseconds");
    }
}
