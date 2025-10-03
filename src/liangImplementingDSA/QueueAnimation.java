package liangImplementingDSA;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.LinkedList;
import java.util.Queue;

public class QueueAnimation extends JPanel {
    private Queue<String> queue = new LinkedList<>();
    private int cellSize = 50;
    private int cellSpacing = 10;

    public QueueAnimation() {
        setPreferredSize(new Dimension(800, 200));
        setBackground(Color.WHITE);

        JButton enqueueButton = new JButton("Enqueue");
        JButton dequeueButton = new JButton("Dequeue");

        JTextField valueField = new JTextField(5);

        enqueueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String value = valueField.getText();
                if (!value.isEmpty()) {
                    enqueueElement(value);
                }
            }
        });

        dequeueButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dequeueElement();
            }
        });

        JFrame frame = new JFrame("Queue Animation");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this, BorderLayout.CENTER);

        JPanel controlPanel = new JPanel();
        controlPanel.add(valueField);
        controlPanel.add(enqueueButton);
        controlPanel.add(dequeueButton);

        frame.add(controlPanel, BorderLayout.SOUTH);
        frame.pack();
        frame.setVisible(true);
    }

    private void enqueueElement(String value) {
        queue.offer(value);
        repaint();
    }

    private void dequeueElement() {
        if (!queue.isEmpty()) {
            queue.poll();
            repaint();
        } else {
            System.out.println("Queue is empty");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = 50;
        for (String value : queue) {
            g.drawRect(x, 50, cellSize, cellSize);
            g.drawString(value, x + 10, 75);
            x += cellSize + cellSpacing;
        }
    }

    public static void main(String[] args) {
        new QueueAnimation();
    }
}
