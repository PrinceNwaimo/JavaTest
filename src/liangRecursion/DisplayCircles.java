package liangRecursion;

import javax.swing.*;
import java.awt.*;

public class DisplayCircles extends JPanel {
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int gap = 10;
        int diameter = Math.min(getWidth(), getHeight()) - 2 * gap;
        int x = (getWidth() - diameter) / 2;
        int y = (getHeight() - diameter) / 2;
        while (diameter > 0) {
            g.drawOval(x, y, diameter, diameter);
            diameter -= 20;
            x += 10;
            y += 10;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Display Circles");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new DisplayCircles());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
