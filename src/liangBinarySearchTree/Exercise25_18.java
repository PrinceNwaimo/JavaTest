package liangBinarySearchTree;
import java.io.*;
import java.util.*;

public class Exercise25_18 {
        public static void main(String[] args) throws Exception {
            if (args.length != 2) {
                System.out.println("Usage: java Exercise25_18 sourceFile targetFile");
                System.exit(1);
            }

            File sourceFile = new File(args[0]);
            File targetFile = new File(args[1]);

            if (!sourceFile.exists()) {
                System.out.println("Source file " + args[0] + " does not exist");
                System.exit(2);
            }


            // Step 1: Build frequency table
            int[] counts = getCharacterFrequency(sourceFile);

            // Step 2: Build Huffman tree
            HuffmanTree tree = new HuffmanTree(counts);

            // Step 3: Get code table
            String[] codes = tree.getCodeTable();

            // Step 4: Write code table and encoded data
            try (
//                    ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(targetFile));
//                    BitOutputStream bitOut = new BitOutputStream(targetFile)
                    FileOutputStream fileOut = new FileOutputStream(targetFile);
            ObjectOutputStream output = new ObjectOutputStream(fileOut);
            ) {
                // First, write code table as an int[] (frequency table)
                output.writeObject(counts);

                // Move file pointer to continue writing bits after object
                output.flush();
                long bitStart = fileOut.getChannel().position();

                // Re-open BitOutputStream from that position
                try (RandomAccessFile raf = new RandomAccessFile(targetFile, "rw")) {
                    raf.seek(bitStart);
                    BitOutputStream bitOutput = new BitOutputStream(new File(targetFile.getPath()));

                    try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(sourceFile))) {
                        int b;
                        while ((b = input.read()) != -1) {
                            String code = codes[b];
                            for (char bit : code.toCharArray()) {
                                bitOutput.writeBit(bit);
                            }
                        }
                        bitOutput.close();
                    }
                }
            }

            System.out.println("File " + sourceFile.getName() + " compressed to " + targetFile.getName());
        }

        private static int[] getCharacterFrequency(File file) throws IOException {
            int[] counts = new int[256];
            try (BufferedInputStream input = new BufferedInputStream(new FileInputStream(file))) {
                int b;
                while ((b = input.read()) != -1) {
                    counts[b]++;
                }
            }
            return counts;
        }
    }


