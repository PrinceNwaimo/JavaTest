package liangRecursion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SierpinskiTriangle extends JFrame {
    private int order = 0;
    private TrianglePanel trianglePanel;

    public SierpinskiTriangle() {
        JButton increaseButton = new JButton("+");
        JButton decreaseButton = new JButton("-");

        increaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                order++;
                trianglePanel.repaint();
            }
        });

        decreaseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (order > 0) {
                    order--;
                    trianglePanel.repaint();
                }
            }
        });

        trianglePanel = new TrianglePanel();

        JPanel panel = new JPanel();
        panel.add(decreaseButton);
        panel.add(increaseButton);

        add(panel, BorderLayout.NORTH);
        add(trianglePanel, BorderLayout.CENTER);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private class TrianglePanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Point p1 = new Point(getWidth() / 2, 10);
            Point p2 = new Point(10, getHeight() - 10);
            Point p3 = new Point(getWidth() - 10, getHeight() - 10);
            displayTriangles(g, order, p1, p2, p3);
        }

        private void displayTriangles(Graphics g, int order, Point p1, Point p2, Point p3) {
            if (order == 0) {
                g.drawPolygon(new int[]{p1.x, p2.x, p3.x}, new int[]{p1.y, p2.y, p3.y}, 3);
            } else {
                Point p12 = midpoint(p1, p2);
                Point p23 = midpoint(p2, p3);
                Point p31 = midpoint(p3, p1);

                displayTriangles(g, order - 1, p1, p12, p31);
                displayTriangles(g, order - 1, p12, p2, p23);
                displayTriangles(g, order - 1, p31, p23, p3);
            }
        }

        private Point midpoint(Point p1, Point p2) {
            return new Point((p1.x + p2.x) / 2, (p1.y + p2.y) / 2);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new SierpinskiTriangle();
            }
        });
    }
}
