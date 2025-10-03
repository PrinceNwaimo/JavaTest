package liangImplementingDSA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ArrayListAnimation2 extends JPanel {
    private ArrayList<String> list = new ArrayList<>();
    private int cellSize = 50;
    private int cellSpacing = 10;
    private int animationSpeed = 500; // milliseconds

    public ArrayListAnimation2() {
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
                    searchElement(value);
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
                        insertElement(value, list.size());
                    } else {
                        insertElement(value, Integer.parseInt(index));
                    }
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = valueField.getText();
                if (!value.isEmpty()) {
                    deleteElement(value);
                }
            }
        });

        JFrame frame = new JFrame("Array List Animation");
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

    private void searchElement(String value) {
        int index = list.indexOf(value);
        if (index != -1) {
            System.out.println("Element found at index: " + index);
        } else {
            System.out.println("Element not found");
        }
    }

    private void insertElement(String value, int index) {
        if (index >= 0 && index <= list.size()) {
            list.add(index, value);
            animateList();
        } else {
            System.out.println("Invalid index");
        }
    }

    private void deleteElement(String value) {
        if (list.remove(value)) {
            animateList();
        } else {
            System.out.println("Element not found");
        }
    }

    private void animateList() {
        repaint();
        try {
            Thread.sleep(animationSpeed);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 50;
        for (int i = 0; i < list.size(); i++) {
            g.drawRect(x, 50, cellSize, cellSize);
            g.drawString(list.get(i), x + 10, 75);
            g.drawString(String.valueOf(i), x + 10, 100);
            x += cellSize + cellSpacing;
        }
    }

    public static void main(String[] args) {
        new ArrayListAnimation();
    }
}
