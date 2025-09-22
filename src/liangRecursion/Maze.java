package liangRecursion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Maze extends JPanel {
    private final int ROWS = 8;
    private final int COLS = 8;
    private boolean[][] marked = new boolean[ROWS][COLS];
    private boolean pathFound = false;

    public Maze() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = e.getY() / (getHeight() / ROWS);
                int col = e.getX() / (getWidth() / COLS);
                marked[row][col] = !marked[row][col];
                repaint();
                if (!pathFound) {
                    pathFound = findPath(0, 0, ROWS - 1, COLS - 1);
                    repaint();
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellWidth = getWidth() / COLS;
        int cellHeight = getHeight() / ROWS;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (marked[i][j]) {
                    g.setColor(Color.BLACK);
                    g.fillRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
                }
                g.setColor(Color.BLACK);
                g.drawRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
            }
        }
        if (pathFound) {
            drawPath(g);
        }
    }

    private boolean findPath(int x1, int y1, int x2, int y2) {
        if (x1 < 0 || x1 >= ROWS || y1 < 0 || y1 >= COLS || marked[x1][y1]) {
            return false;
        }
        marked[x1][y1] = true;
        if (x1 == x2 && y1 == y2) {
            return true;
        }
        if (findPath(x1 + 1, y1, x2, y2) || findPath(x1 - 1, y1, x2, y2)
                || findPath(x1, y1 + 1, x2, y2) || findPath(x1, y1 - 1, x2, y2)) {
            return true;
        }
        marked[x1][y1] = false;
        return false;
    }

    private void drawPath(Graphics g) {
        g.setColor(Color.RED);
        int cellWidth = getWidth() / COLS;
        int cellHeight = getHeight() / ROWS;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (marked[i][j]) {
                    g.fillRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
                }
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Maze());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
