package liangRecursion;

import javax.swing.*;
import java.awt.*;

public class RecursiveTree extends JPanel {
    private int depth = 8;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawTree(g, getWidth() / 2, getHeight(), 100, Math.PI / 2, depth);
    }

    private void drawTree(Graphics g, int x1, int y1, double length, double angle, int depth) {
        if (depth == 0) {
            return;
        }

        int x2 = x1 + (int) (length * Math.cos(angle));
        int y2 = y1 - (int) (length * Math.sin(angle));

        g.drawLine(x1, y1, x2, y2);

        drawTree(g, x2, y2, length * 0.7, angle - Math.PI / 6, depth - 1);
        drawTree(g, x2, y2, length * 0.7, angle + Math.PI / 6, depth - 1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Recursive Tree");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new RecursiveTree());
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
