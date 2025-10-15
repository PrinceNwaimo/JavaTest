package diettelRecursion;

import javax.swing.*;
import java.awt.*;

public class StarFractal extends JPanel {
    private final int LEVELS = 4;

    public StarFractal() {
        setPreferredSize(new Dimension(800, 800));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int length = 200;

        for (int i = 0; i < 5; i++) {
            double angle = Math.toRadians(90 + i * 144);
            drawFractal(g2d, centerX, centerY, length, angle, LEVELS, getColor(i));
        }
    }

    private void drawFractal(Graphics2D g2d, int x, int y, int length, double angle, int level, Color color) {
        if (level == 0) {
            return;
        }

        int x2 = x + (int) (length * Math.cos(angle));
        int y2 = y - (int) (length * Math.sin(angle));

        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(level));
        g2d.drawLine(x, y, x2, y2);

        drawFractal(g2d, x2, y2, length / 2, angle + Math.PI / 3, level - 1, color);
        drawFractal(g2d, x2, y2, length / 2, angle - Math.PI / 3, level - 1, color);
    }

    private Color getColor(int index) {
        switch (index) {
            case 0:
                return Color.RED;
            case 1:
                return Color.ORANGE;
            case 2:
                return Color.YELLOW;
            case 3:
                return Color.GREEN;
            case 4:
                return Color.BLUE;
            default:
                return Color.BLACK;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Star Fractal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new StarFractal());
        frame.pack();
        frame.setVisible(true);
    }
}
