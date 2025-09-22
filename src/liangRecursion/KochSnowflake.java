package liangRecursion;

import javax.swing.*;
import java.awt.*;

public class KochSnowflake extends JPanel {
    private int order = 3;

    public KochSnowflake() {
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Point p1 = new Point(200, 50);
        Point p2 = new Point(50, 350);
        Point p3 = new Point(350, 350);
        drawKochSnowflake(g, order, p1, p2);
        drawKochSnowflake(g, order, p2, p3);
        drawKochSnowflake(g, order, p3, p1);
    }

    private void drawKochSnowflake(Graphics g, int order, Point p1, Point p2) {
        if (order == 0) {
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        } else {
            Point p12 = getPoint(p1, p2, 1.0 / 3.0);
            Point p23 = getPoint(p1, p2, 2.0 / 3.0);
            Point pm = getMiddlePoint(p12, p23);
            drawKochSnowflake(g, order - 1, p1, p12);
            drawKochSnowflake(g, order - 1, p12, pm);
            drawKochSnowflake(g, order - 1, pm, p23);
            drawKochSnowflake(g, order - 1, p23, p2);
        }
    }

    private Point getPoint(Point p1, Point p2, double ratio) {
        return new Point((int) (p1.x + (p2.x - p1.x) * ratio), (int) (p1.y + (p1.y - p2.y) * ratio + p2.y));
    }

    private Point getMiddlePoint(Point p1, Point p2) {
        double x = (p1.x + p2.x) / 2.0;
        double y = (p1.y + p2.y) / 2.0;
        double length = Math.sqrt(Math.pow(p2.x - p1.x, 2) + Math.pow(p2.y - p1.y, 2)) / Math.sqrt(3);
        double angle = Math.atan2(p2.y - p1.y, p2.x - p1.x) + Math.PI / 6.0;
        x += length * Math.cos(angle);
        y += length * Math.sin(angle);
        return new Point((int) x, (int) y);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Koch Snowflake");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new KochSnowflake());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
