package liangRecursion;

import javax.swing.*;
import java.awt.*;

public class HTreeFractal extends JPanel {
    private int order = 5;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x = getWidth() / 2;
        int y = getHeight() / 2;
        int size = Math.min(getWidth(), getHeight()) / 2;
        drawHTree(g, x, y, size, order);
    }

    private void drawHTree(Graphics g, int x, int y, int size, int order) {
        if (order == 0) {
            return;
        }

        // Draw H
        g.drawLine(x - size, y, x + size, y); // Horizontal line
        g.drawLine(x - size, y, x - size, y - size); // Left vertical line
        g.drawLine(x - size, y, x - size, y + size); // Left vertical line
        g.drawLine(x + size, y, x + size, y - size); // Right vertical line
        g.drawLine(x + size, y, x + size, y + size); // Right vertical line

        // Recursively draw H-trees at the four endpoints
        drawHTree(g, x - size, y - size, size / 2, order - 1);
        drawHTree(g, x - size, y + size, size / 2, order - 1);
        drawHTree(g, x + size, y - size, size / 2, order - 1);
        drawHTree(g, x + size, y + size, size / 2, order - 1);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("H-Tree Fractal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new HTreeFractal());
        frame.setSize(800, 800);
        frame.setVisible(true);
    }
}
