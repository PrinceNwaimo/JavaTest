package liangBinarySearchTree;
import java.io.*;
import java.util.*;

public class Exercise25_19 {


        public static void main(String[] args) throws Exception {
            if (args.length != 2) {
                System.out.println("Usage: java Exercise25_19 sourceFile targetFile");
                System.exit(1);
            }

            File sourceFile = new File(args[0]);
            File targetFile = new File(args[1]);

            if (!sourceFile.exists()) {
                System.out.println("Source file " + args[0] + " does not exist");
                System.exit(2);
            }

            // Step 1: Read code table (frequency table)
            ObjectInputStream input = new ObjectInputStream(new FileInputStream(sourceFile));
            int[] counts = (int[]) input.readObject();

            // Step 2: Rebuild Huffman tree
            HuffmanTree tree = new HuffmanTree(counts);

            // Step 3: Decode the bits and write characters
            try (BufferedOutputStream output = new BufferedOutputStream(new FileOutputStream(targetFile))) {
                HuffmanTree.TreeNode root = tree.getRoot();
                HuffmanTree.TreeNode current = root;

                int byteRead;
                int numBitsRead;
                while ((byteRead = input.read()) != -1) {
                    for (int i = 7; i >= 0; i--) {
                        int bit = (byteRead >> i) & 1;
                        if (bit == 0) current = current.left;
                        else current = current.right;

                        if (current.left == null && current.right == null) {
                            output.write(current.element);
                            current = root;
                        }
                    }
                }
            }

            input.close();
            System.out.println("File " + sourceFile.getName() + " decompressed to " + targetFile.getName());
        }
    }


