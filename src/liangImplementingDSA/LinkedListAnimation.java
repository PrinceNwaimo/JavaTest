package liangImplementingDSA;

import javax.swing.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LinkedListAnimation extends JPanel {
    private Node head;
    private int nodeSize = 30;
    private int nodeSpacing = 50;

    public LinkedListAnimation() {
        setPreferredSize(new Dimension(800, 200));
        setBackground(Color.WHITE);

        JButton searchButton = new JButton("Search");
        JButton insertButton = new JButton("Insert");
        JButton deleteButton = new JButton("Delete");

        JTextField valueField = new JTextField(5);
        JTextField indexField = new JTextField(5);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = valueField.getText();
                if (!value.isEmpty()) {
                    searchNode(value);
                }
            }
        });

        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = valueField.getText();
                String index = indexField.getText();
                if (!value.isEmpty()) {
                    if (index.isEmpty()) {
                        insertNode(value, -1);
                    } else {
                        insertNode(value, Integer.parseInt(index));
                    }
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = valueField.getText();
                if (!value.isEmpty()) {
                    deleteNode(value);
                }
            }
        });

        JFrame frame = new JFrame("Linked List Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.add(new JLabel("Value:"));
        controlPanel.add(valueField);
        controlPanel.add(new JLabel("Index:"));
        controlPanel.add(indexField);
        controlPanel.add(searchButton);
        controlPanel.add(insertButton);
        controlPanel.add(deleteButton);

        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    private void searchNode(String value) {
        Node current = head;
        while (current != null) {
            if (current.value.equals(value)) {
                System.out.println("Node found: " + value);
                return;
            }
            current = current.next;
        }
        System.out.println("Node not found: " + value);
    }

    private void insertNode(String value, int index) {
        Node newNode = new Node(value);
        if (head == null || index == 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1 && current.next != null; i++) {
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
        }
        repaint();
    }

    private void deleteNode(String value) {
        if (head == null) return;
        if (head.value.equals(value)) {
            head = head.next;
            repaint();
            return;
        }
        Node current = head;
        while (current.next != null) {
            if (current.next.value.equals(value)) {
                current.next = current.next.next;
                repaint();
                return;
            }
            current = current.next;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Node current = head;
        int x = 50;
        while (current != null) {
            g.drawRect(x, 50, nodeSize, nodeSize);
            g.drawString(current.value, x + 10, 75);
            if (current.next != null) {
                g.drawLine(x + nodeSize, 75, x + nodeSpacing, 75);
            }
            x += nodeSpacing;
            current = current.next;
        }
    }

    private class Node {
        String value;
        Node next;

        public Node(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        new LinkedListAnimation();
    }
}
