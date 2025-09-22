package liangRecursion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class KnightsTour extends JPanel {
    private final int ROWS = 8;
    private final int COLS = 8;
    private int[][] board = new int[ROWS][COLS];
    private int startX = -1;
    private int startY = -1;
    private boolean solved = false;

    public KnightsTour() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = e.getY() / (getHeight() / ROWS);
                int col = e.getX() / (getWidth() / COLS);
                startX = row;
                startY = col;
                solved = false;
                for (int i = 0; i < ROWS; i++) {
                    for (int j = 0; j < COLS; j++) {
                        board[i][j] = 0;
                    }
                }
                repaint();
            }
        });

        JButton solveButton = new JButton("Solve");
        solveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (startX != -1 && startY != -1) {
                    for (int i = 0; i < ROWS; i++) {
                        for (int j = 0; j < COLS; j++) {
                            board[i][j] = 0;
                        }
                    }
                    board[startX][startY] = 1;
                    if (solveKnight(startX, startY, 2)) {
                        solved = true;
                    } else {
                        JOptionPane.showMessageDialog(null, "No solution exists");
                    }
                    repaint();
                }
            }
        });

        JFrame frame = new JFrame("Knight's Tour");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this, BorderLayout.CENTER);
        frame.add(solveButton, BorderLayout.SOUTH);
        frame.setSize(400, 400);
        frame.setVisible(true);
    }

    private boolean solveKnight(int x, int y, int move) {
        if (move > ROWS * COLS) {
            return true;
        }

        int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        int minDeg = 9;
        int nextX = -1;
        int nextY = -1;

        for (int[] m : moves) {
            int newX = x + m[0];
            int newY = y + m[1];
            if (isValidMove(newX, newY)) {
                int deg = getDegree(newX, newY);
                if (deg < minDeg) {
                    minDeg = deg;
                    nextX = newX;
                    nextY = newY;
                }
            }
        }

        if (nextX != -1) {
            board[nextX][nextY] = move;
            if (solveKnight(nextX, nextY, move + 1)) {
                return true;
            }
            board[nextX][nextY] = 0;
        }

        return false;
    }

    private int getDegree(int x, int y) {
        int[][] moves = {{-2, -1}, {-2, 1}, {-1, -2}, {-1, 2}, {1, -2}, {1, 2}, {2, -1}, {2, 1}};
        int count = 0;
        for (int[] m : moves) {
            int newX = x + m[0];
            int newY = y + m[1];
            if (isValidMove(newX, newY)) {
                count++;
            }
        }
        return count;
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < ROWS && y >= 0 && y < COLS && board[x][y] == 0;
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
                if (solved || (i == startX && j == startY)) {
                    g.setColor(Color.BLACK);
                    g.drawString(String.valueOf(board[i][j]), j * cellWidth + cellWidth / 2 - 5, i * cellHeight + cellHeight / 2 + 5);
                }
                g.setColor(Color.BLACK);
                g.drawRect(j * cellWidth, i * cellHeight, cellWidth, cellHeight);
            }
        }
    }

    public static void main(String[] args) {
        new KnightsTour();
    }
}
