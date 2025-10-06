package liangBinarySearchTree;
import java.io.*;
import java.util.*;
public class HuffmanCoding {
        // Node for Huffman tree
        static class HuffmanNode implements Comparable<HuffmanNode> {
            char character;
            int frequency;
            HuffmanNode left;
            HuffmanNode right;

            public HuffmanNode(char character, int frequency) {
                this.character = character;
                this.frequency = frequency;
            }

            public HuffmanNode(int frequency, HuffmanNode left, HuffmanNode right) {
                this.character = '\0'; // internal node
                this.frequency = frequency;
                this.left = left;
                this.right = right;
            }

            @Override
            public int compareTo(HuffmanNode other) {
                return this.frequency - other.frequency;
            }

            public boolean isLeaf() {
                return (left == null && right == null);
            }
        }

        public static void main(String[] args) throws IOException {
            Scanner input = new Scanner(System.in);
            System.out.print("Enter a file name: ");
            String filename = input.nextLine();

            File file = new File(filename);
            if (!file.exists()) {
                System.out.println("File does not exist.");
                return;
            }

            // Step 1: Count frequencies
            int[] freq = new int[256]; // for ASCII
            FileInputStream fis = new FileInputStream(file);
            int b;
            while ((b = fis.read()) != -1) {
                freq[b]++;
            }
            fis.close();

            // Step 2: Build Huffman tree
            HuffmanNode root = buildHuffmanTree(freq);

            if (root == null) {
                System.out.println("File is empty or has no valid characters.");
                return;
            }

            // Step 3: Generate Huffman codes
            Map<Character, String> huffmanCodes = new HashMap<>();
            generateCodes(root, "", huffmanCodes);

            // Step 4: Display frequency table
            System.out.println("\nCharacter\tFrequency\tHuffman Code");
            System.out.println("---------------------------------------------");
            for (int i = 0; i < freq.length; i++) {
                if (freq[i] > 0) {
                    char c = (char) i;
                    String displayChar = (c == '\n') ? "\\n" : (c == '\r') ? "\\r" : (c == '\t') ? "\\t" : Character.toString(c);
                    System.out.printf("%-10s\t%-9d\t%s%n", displayChar, freq[i], huffmanCodes.get(c));
                }
            }
        }

        /** Build the Huffman tree from frequency table */
        private static HuffmanNode buildHuffmanTree(int[] freq) {
            PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();

            for (int i = 0; i < freq.length; i++) {
                if (freq[i] > 0) {
                    pq.offer(new HuffmanNode((char) i, freq[i]));
                }
            }

            if (pq.isEmpty()) return null;

            while (pq.size() > 1) {
                HuffmanNode n1 = pq.poll();
                HuffmanNode n2 = pq.poll();
                HuffmanNode parent = new HuffmanNode(n1.frequency + n2.frequency, n1, n2);
                pq.offer(parent);
            }

            return pq.poll();
        }

        /** Generate Huffman codes recursively */
        private static void generateCodes(HuffmanNode node, String code, Map<Character, String> codes) {
            if (node.isLeaf()) {
                codes.put(node.character, code.length() > 0 ? code : "0"); // handle single char case
                return;
            }
            generateCodes(node.left, code + "0", codes);
            generateCodes(node.right, code + "1", codes);
        }
    }


