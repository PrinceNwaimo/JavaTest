package liangSortingAlgorithms;

import java.io.IOException;
import java.io.*;
import java.util.*;

public class ExternalSortTimeComparison {
    public static void main(String[] args) throws IOException {
        int[] sizes = {5_000_000, 10_000_000, 15_000_000, 20_000_000, 25_000_000, 30_000_000};
        System.out.println("File size\tTime");
        for (int size : sizes) {
            generateRandomFile(size);
            long startTime = System.currentTimeMillis();
            externalSort("random_numbers.txt", "sorted_numbers.txt");
            long endTime = System.currentTimeMillis();
            System.out.println(size + "\t" + (endTime - startTime) + " ms");
        }
    }

    private static void generateRandomFile(int size) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("random_numbers.txt"))) {
            Random random = new Random();
            for (int i = 0; i < size; i++) {
                writer.write(random.nextInt() + "\n");
            }
        }
    }

    private static void externalSort(String inputFile, String outputFile) throws IOException {
        int bufferSize = 100000;
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                queue.offer(Integer.parseInt(line));
                if (queue.size() > bufferSize) {
                    writeToTempFile(queue, "temp");
                }
            }
            writeToTempFile(queue, "temp");
        }

        List<File> files = new ArrayList<>();
        for (int i = 0; i < bufferSize; i++) {
            files.add(new File("temp" + i + ".txt"));
        }

        mergeFiles(files, outputFile);
        for (File file : files) {
            file.delete();
        }
    }
    private static void writeToTempFile(PriorityQueue<Integer> queue, String prefix) throws IOException {
        int fileIndex = 0;
        int charsWritten = 0;
        BufferedWriter writer = new BufferedWriter(new FileWriter(prefix + fileIndex + ".txt"));
        try {
            while (!queue.isEmpty()) {
                String str = queue.poll() + "\n";
                writer.write(str);
                charsWritten += str.length();
                if (charsWritten >= 1024 * 1024) {
                    charsWritten = 0;
                    writer.close();
                    fileIndex++;
                    writer = new BufferedWriter(new FileWriter(prefix + fileIndex + ".txt"));
                }
            }
        } finally {
            writer.close();
        }
    }

    private static void mergeFiles(List<File> files, String outputFile) throws IOException {
        List<BufferedReader> readers = new ArrayList<>();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile))) {
            for (File file : files) {
                readers.add(new BufferedReader(new FileReader(file)));
            }

            PriorityQueue<Pair> queue = new PriorityQueue<>();
            for (int i = 0; i < readers.size(); i++) {
                String line = readers.get(i).readLine();
                if (line != null) {
                    queue.offer(new Pair(Integer.parseInt(line), i));
                }
            }

            while (!queue.isEmpty()) {
                Pair pair = queue.poll();
                writer.write(pair.value + "\n");
                String line = readers.get(pair.fileIndex).readLine();
                if (line != null) {
                    queue.offer(new Pair(Integer.parseInt(line), pair.fileIndex));
                }
            }
        } finally {
            for (BufferedReader reader : readers) {
                reader.close();
            }
        }
    }

    private static class Pair implements Comparable<Pair> {
        int value;
        int fileIndex;

        public Pair(int value, int fileIndex) {
            this.value = value;
            this.fileIndex = fileIndex;
        }

        @Override
        public int compareTo(Pair other) {
            return Integer.compare(value, other.value);
        }
    }
}
