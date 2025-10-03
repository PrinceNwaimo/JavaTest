package liangImplementingDSA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.NoSuchElementException;

public class DoublyLinkedListAnimation extends JPanel {
    private DoublyLinkedList list = new DoublyLinkedList();
    private int nodeSize = 50;
    private int nodeSpacing = 50;

    public DoublyLinkedListAnimation() {
        setPreferredSize(new Dimension(800, 200));
        setBackground(Color.WHITE);

        JButton searchButton = new JButton("Search");
        JButton insertButton = new JButton("Insert");
        JButton deleteButton = new JButton("Delete");
        JButton forwardTraversalButton = new JButton("Forward Traversal");
        JButton backwardTraversalButton = new JButton("Backward Traversal");

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
                        insertNode(value, list.size());
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

        forwardTraversalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                forwardTraversal();
            }
        });

        backwardTraversalButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backwardTraversal();
            }
        });

        JFrame frame = new JFrame("Doubly Linked List Animation");
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
        controlPanel.add(forwardTraversalButton);
        controlPanel.add(backwardTraversalButton);

        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    private void searchNode(String value) {
        Node current = list.head;
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
        if (index < 0 || index > list.size()) {
            System.out.println("Invalid index");
            return;
        }
        list.insert(index, value);
        repaint();
    }

    private void deleteNode(String value) {
        list.remove(value);
        repaint();
    }

    private void forwardTraversal() {
        StringBuilder sb = new StringBuilder();
        Node current = list.head;
        while (current != null) {
            sb.append(current.value).append(" ");
            current = current.next;
        }
        System.out.println("Forward Traversal: " + sb.toString());
    }

    private void backwardTraversal() {
        StringBuilder sb = new StringBuilder();
        Node current = list.tail;
        while (current != null) {
            sb.append(current.value).append(" ");
            current = current.prev;
        }
        System.out.println("Backward Traversal: " + sb.toString());
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Node current = list.head;
        int x = 50;
        while (current != null) {
            g.drawRect(x, 50, nodeSize, nodeSize);
            g.drawString(current.value, x + 10, 75);
            if (current.next != null) {
                g.drawLine(x + nodeSize, 75, x + nodeSpacing, 75);
            }
            if (current.prev != null) {
                g.drawLine(x, 75, x - nodeSpacing + nodeSize, 75);
            }
            x += nodeSpacing;
            current = current.next;
        }
    }

    private class DoublyLinkedList {
        Node head;
        Node tail;
        int size;

        public void insert(int index, String value) {
            if (index == 0) {
                Node newNode = new Node(value);
                newNode.next = head;
                if (head != null) {
                    head.prev = newNode;
                } else {
                    tail = newNode;
                }
                head = newNode;
            } else if (index == size) {
                Node newNode = new Node(value);
                newNode.prev = tail;
                if (tail != null) {
                    tail.next = newNode;
                } else {
                    head = newNode;
                }
                tail = newNode;
            } else {
                Node current = head;
                for (int i = 0; i < index - 1; i++) {
                    current = current.next;
                }
                Node newNode = new Node(value);
                newNode.next = current.next;
                newNode.prev = current;
                current.next.prev = newNode;
                current.next = newNode;
            }
            size++;
        }

        public void remove(String value) {
            Node current = head;
            while (current != null) {
                if (current.value.equals(value)) {
                    if (current.prev != null) {
                        current.prev.next = current.next;
                    } else {
                        head = current.next;
                    }
                    if (current.next != null) {
                        current.next.prev = current.prev;
                    } else {
                        tail = current.prev;
                    }
                    size--;
                    return;
                }
                current = current.next;
            }
        }

        public int size() {
            return size;
        }
    }

    private class Node {
        String value;
        Node next;
        Node prev;

        public Node(String value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        new DoublyLinkedListAnimation();
    }
}
