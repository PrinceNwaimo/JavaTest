package liangRecursion;

import javax.swing.*;
import java.awt.*;

public class EightQueens extends JPanel {
    private final int ROWS = 8;
    private final int COLS = 8;
    private int[] queens = new int[ROWS];

    public EightQueens() {
        solveQueens(0);
    }

    private boolean solveQueens(int row) {
        if (row == ROWS) {
            return true;
        }
        for (int col = 0; col < COLS; col++) {
            if (isValid(row, col)) {
                queens[row] = col;
                if (solveQueens(row + 1)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean isValid(int row, int col) {
        for (int i = 0; i < row; i++) {
            if (queens[i] == col || queens[i] - i == col - row || queens[i] + i == col + row) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellWidth = getWidth() / COLS;
        int cellHeight = getHeight() / ROWS;
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if ((i + j) % 2 == 0) {
                    g.setColor(Color.WHITE);
                } else {
                    g.setColor(Color.GRAY);
                }
                g.fillRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
                if (queens[i] == j) {
                    g.setColor(Color.RED);
                    g.fillOval(j * cellWidth + cellWidth / 4, i * cellHeight + cellHeight / 4, cellWidth / 2, cellHeight / 2);
                }
                g.setColor(Color.BLACK);
                g.drawRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Eight Queens");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new EightQueens());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
