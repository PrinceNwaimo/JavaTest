package liangBinarySearchTree;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.util.*;

public class HuffmanCodingAnimation extends Application {
    private TextField textField = new TextField();
    private Label encodedLabel = new Label();
    private Label decodedLabel = new Label();
    private Canvas canvas = new Canvas(800, 500);

    private HuffmanNode root;
    private Map<Character, String> huffmanCodes = new HashMap<>();
    private String encodedText = "";

    @Override
    public void start(Stage primaryStage) {
        Button buildTreeBtn = new Button("Build Tree");
        Button decodeBtn = new Button("Decode Text");

        HBox controls = new HBox(10, new Label("Enter text:"), textField, buildTreeBtn, decodeBtn);
        controls.setStyle("-fx-padding: 10; -fx-alignment: center;");

        VBox vbox = new VBox(10, controls, new Label("Encoded bits:"), encodedLabel, new Label("Decoded text:"), decodedLabel, canvas);
        vbox.setStyle("-fx-padding: 10;");

        buildTreeBtn.setOnAction(e -> buildHuffmanTree());
        decodeBtn.setOnAction(e -> decodeText());

        Scene scene = new Scene(vbox);
        primaryStage.setTitle("Huffman Coding Animation");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void buildHuffmanTree() {
        String text = textField.getText();
        if (text == null || text.isEmpty()) {
            encodedLabel.setText("Please enter some text.");
            return;
        }

        // Step 1: Frequency table
        int[] freq = new int[256];
        for (char c : text.toCharArray()) {
            freq[c]++;
        }

        // Step 2: Priority queue
        PriorityQueue<HuffmanNode> pq = new PriorityQueue<>();
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                pq.offer(new HuffmanNode((char) i, freq[i]));
            }
        }

        // Step 3: Build tree
        while (pq.size() > 1) {
            HuffmanNode n1 = pq.poll();
            HuffmanNode n2 = pq.poll();
            HuffmanNode parent = new HuffmanNode('\0', n1.frequency + n2.frequency);
            parent.left = n1;
            parent.right = n2;
            pq.offer(parent);
        }

        root = pq.poll();
        huffmanCodes.clear();

        // Step 4: Generate codes
        generateCodes(root, "");

        // Step 5: Encode text
        StringBuilder sb = new StringBuilder();
        for (char c : text.toCharArray()) {
            sb.append(huffmanCodes.get(c));
        }
        encodedText = sb.toString();
        encodedLabel.setText(encodedText);

        // Step 6: Draw tree
        drawTree();
    }

    private void generateCodes(HuffmanNode node, String code) {
        if (node == null) return;

        if (node.isLeaf()) {
            huffmanCodes.put(node.character, code.length() > 0 ? code : "0");
        } else {
            generateCodes(node.left, code + "0");
            generateCodes(node.right, code + "1");
        }
    }

    private void decodeText() {
        if (root == null || encodedText.isEmpty()) {
            decodedLabel.setText("No encoded text.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        HuffmanNode current = root;
        for (char bit : encodedText.toCharArray()) {
            current = (bit == '0') ? current.left : current.right;
            if (current.isLeaf()) {
                sb.append(current.character);
                current = root;
            }
        }

        decodedLabel.setText(sb.toString());
    }

    private void drawTree() {
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        if (root != null) {
            drawNode(gc, root, canvas.getWidth() / 2, 50, canvas.getWidth() / 4);
        }
    }

    private void drawNode(GraphicsContext gc, HuffmanNode node, double x, double y, double gap) {
        double radius = 20;
        gc.setStroke(Color.BLACK);
        gc.setFill(Color.LIGHTYELLOW);
        gc.fillOval(x - radius, y - radius, radius * 2, radius * 2);
        gc.strokeOval(x - radius, y - radius, radius * 2, radius * 2);

        gc.setFill(Color.BLACK);
        gc.setFont(Font.font(12));
        if (node.isLeaf()) {
            gc.fillText(node.character + ":" + node.frequency, x - 10, y + 4);
        } else {
            gc.fillText(String.valueOf(node.frequency), x - 6, y + 4);
        }

        if (node.left != null) {
            gc.strokeLine(x, y + radius, x - gap, y + 80 - radius);
            drawNode(gc, node.left, x - gap, y + 80, gap / 2);
        }

        if (node.right != null) {
            gc.strokeLine(x, y + radius, x + gap, y + 80 - radius);
            drawNode(gc, node.right, x + gap, y + 80, gap / 2);
        }
    }

    static class HuffmanNode implements Comparable<HuffmanNode> {
        char character;
        int frequency;
        HuffmanNode left;
        HuffmanNode right;

        HuffmanNode(char character, int frequency) {
            this.character = character;
            this.frequency = frequency;
        }

        @Override
        public int compareTo(HuffmanNode o) {
            return this.frequency - o.frequency;
        }

        boolean isLeaf() {
            return left == null && right == null;
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
