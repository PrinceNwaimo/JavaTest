package diettelRecursion;

import javax.swing.*;
import java.awt.*;

public class KochSnowflakes extends JPanel {
    private int level;

    public KochSnowflakes(int level) {
        this.level = level;
        setPreferredSize(new Dimension(800, 600));
        setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int x1 = 100;
        int y1 = 200;
        int x2 = 700;
        int y2 = 200;
        int x3 = 400;
        int y3 = 600;

        drawKochCurve(g2d, x1, y1, x2, y2, level);
        drawKochCurve(g2d, x2, y2, x3, y3, level);
        drawKochCurve(g2d, x3, y3, x1, y1, level);
    }

    private void drawKochCurve(Graphics2D g2d, double x1, double y1, double x2, double y2, int level) {
        if (level == 0) {
            g2d.drawLine((int) x1, (int) y1, (int) x2, (int) y2);
        } else {
            double x3 = x1 + (x2 - x1) / 3;
            double y3 = y1 + (y2 - y1) / 3;
            double x4 = (x1 + x2) / 2 + (y1 - y2) * Math.sqrt(3) / 6;
            double y4 = (y1 + y2) / 2 + (x2 - x1) * Math.sqrt(3) / 6;
            double x5 = x1 + 2 * (x2 - x1) / 3;
            double y5 = y1 + 2 * (y2 - y1) / 3;

            drawKochCurve(g2d, x1, y1, x3, y3, level - 1);
            drawKochCurve(g2d, x3, y3, x4, y4, level - 1);
            drawKochCurve(g2d, x4, y4, x5, y5, level - 1);
            drawKochCurve(g2d, x5, y5, x2, y2, level - 1);
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Koch Snowflake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new KochSnowflakes(4));
        frame.pack();
        frame.setVisible(true);
    }
}
