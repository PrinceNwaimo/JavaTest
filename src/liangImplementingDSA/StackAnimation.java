package liangImplementingDSA;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

public class StackAnimation extends JPanel {
    private Stack<String> stack = new Stack<>();
    private int cellSize = 50;
    private int cellSpacing = 10;

    public StackAnimation() {
        setPreferredSize(new Dimension(200, 400));
        setBackground(Color.WHITE);

        JButton pushButton = new JButton("Push");
        JButton popButton = new JButton("Pop");

        JTextField valueField = new JTextField(5);

        pushButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = valueField.getText();
                if (!value.isEmpty()) {
                    pushElement(value);
                }
            }
        });

        popButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                popElement();
            }
        });

        JFrame frame = new JFrame("Stack Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.add(valueField);
        controlPanel.add(pushButton);
        controlPanel.add(popButton);

        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    private void pushElement(String value) {
        stack.push(value);
        repaint();
    }

    private void popElement() {
        if (!stack.isEmpty()) {
            stack.pop();
            repaint();
        } else {
            System.out.println("Stack is empty");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int y = getHeight() - 50;
        for (String value : stack) {
            g.drawRect(50, y, cellSize, cellSize);
            g.drawString(value, 60, y + 30);
            y -= cellSize + cellSpacing;
        }
    }

    public static void main(String[] args) {
        new StackAnimation();
    }
}
