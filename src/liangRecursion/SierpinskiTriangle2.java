package liangRecursion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SierpinskiTriangle2 extends JPanel {
    private int order = 0;

    public SierpinskiTriangle2() {
        JButton increaseOrderButton = new JButton("Increase Order");
        increaseOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                order++;
                repaint();
            }
        });

        JButton decreaseOrderButton = new JButton("Decrease Order");
        decreaseOrderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (order > 0) {
                    order--;
                    repaint();
                }
            }
        });

        JFrame frame = new JFrame("Sierpinski Triangle");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this, BorderLayout.CENTER);
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(increaseOrderButton);
        buttonPanel.add(decreaseOrderButton);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setSize(800, 800);
        frame.setVisible(true);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x1 = getWidth() / 2;
        int y1 = 50;
        int x2 = 50;
        int y2 = getHeight() - 50;
        int x3 = getWidth() - 50;
        int y3 = getHeight() - 50;
        drawSierpinskiTriangle(g, order, x1, y1, x2, y2, x3, y3);
    }

    private void drawSierpinskiTriangle(Graphics g, int order, int x1, int y1, int x2, int y2, int x3, int y3) {
        if (order == 0) {
            g.fillPolygon(new int[]{x1, x2, x3}, new int[]{y1, y2, y3}, 3);
        } else {
            int x12 = (x1 + x2) / 2;
            int y12 = (y1 + y2) / 2;
            int x23 = (x2 + x3) / 2;
            int y23 = (y2 + y3) / 2;
            int x13 = (x1 + x3) / 2;
            int y13 = (y1 + y3) / 2;
            drawSierpinskiTriangle(g, order - 1, x1, y1, x12, y12, x13, y13);
            drawSierpinskiTriangle(g, order - 1, x12, y12, x2, y2, x23, y23);
            drawSierpinskiTriangle(g, order - 1, x13, y13, x23, y23, x3, y3);
        }
    }

    public static void main(String[] args) {
        new SierpinskiTriangle();
    }
}
