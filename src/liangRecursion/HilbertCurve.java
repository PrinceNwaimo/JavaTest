package liangRecursion;

import javax.swing.*;
import java.awt.*;

public class HilbertCurve extends JPanel {
    private int order = 5;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int size = Math.min(getWidth(), getHeight());
        drawHilbert(g, order, 0, 0, size, true);
    }

    private void drawHilbert(Graphics g, int order, int x, int y, int size, boolean direction) {
        if (order == 0) {
            return;
        }

        int halfSize = size / 2;

        if (direction) {
            drawHilbert(g, order - 1, x, y, halfSize, false);
            g.drawLine(x, y, x, y + halfSize);
            drawHilbert(g, order - 1, x, y + halfSize, halfSize, true);
            g.drawLine(x, y + halfSize, x + halfSize, y + halfSize);
            drawHilbert(g, order - 1, x + halfSize, y + halfSize, halfSize, true);
            g.drawLine(x + halfSize, y + halfSize, x + halfSize, y);
            drawHilbert(g, order - 1, x + halfSize, y, halfSize, false);
        } else {
            drawHilbert(g, order - 1, x, y, halfSize, true);
            g.drawLine(x, y, x + halfSize, y);
            drawHilbert(g, order - 1, x + halfSize, y, halfSize, false);
            g.drawLine(x + halfSize, y, x + halfSize, y + halfSize);
            drawHilbert(g, order - 1, x + halfSize, y + halfSize, halfSize, false);
            g.drawLine(x + halfSize, y + halfSize, x, y + halfSize);
            drawHilbert(g, order - 1, x, y + halfSize, halfSize, true);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Hilbert Curve");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new HilbertCurve());
        frame.setSize(800, 800);
        frame.setVisible(true);
    }
}
