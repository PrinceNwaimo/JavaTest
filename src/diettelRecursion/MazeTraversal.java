package diettelRecursion;

import javax.swing.*;
import java.awt.*;

public class MazeTraversal extends JPanel {
    private char[][] maze = {
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'},
            {'#', '.', '.', '.', '#', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '.', '#', '.', '#', '.', '#', '#', '#', '#', '.', '#'},
            {'#', '#', '#', '.', '#', '.', '.', '.', '.', '#', '.', '#'},
            {'#', '.', '.', '.', '.', '#', '#', '#', '.', '#', '.', '.'},
            {'#', '#', '#', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
            {'#', '.', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
            {'#', '#', '.', '#', '.', '#', '.', '#', '.', '#', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '#', '.', '#'},
            {'#', '#', '#', '#', '#', '#', '.', '#', '#', '#', '.', '#'},
            {'#', '.', '.', '.', '.', '.', '.', '.', '.', '.', '.', '#'},
            {'#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#', '#'}
    };
    private int startX = 1, startY = 1;
    private int endX = 10, endY = 10;
    private boolean solved = false;

    public MazeTraversal() {
        setPreferredSize(new Dimension(600, 600));
        solveMaze(startX, startY);
    }

    private boolean solveMaze(int x, int y) {
        if (x < 0 || x >= maze.length || y < 0 || y >= maze[0].length || maze[x][y] == '#' || maze[x][y] == '0') {
            return false;
        }
        if (x == endX && y == endY) {
            maze[x][y] = 'E';
            solved = true;
            repaint();
            return true;
        }
        maze[x][y] = 'x';
        repaint();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if (solveMaze(x + 1, y) || solveMaze(x - 1, y) || solveMaze(x, y + 1) || solveMaze(x, y - 1)) {
            return true;
        }
        maze[x][y] = '0';
        repaint();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth() / maze[0].length;
        int height = getHeight() / maze.length;
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                switch (maze[i][j]) {
                    case '#':
                        g.setColor(Color.BLACK);
                        break;
                    case '.':
                        g.setColor(Color.WHITE);
                        break;
                    case 'x':
                        g.setColor(Color.GREEN);
                        break;
                    case '0':
                        g.setColor(Color.RED);
                        break;
                    case 'E':
                        g.setColor(Color.YELLOW);
                        break;
                }
                g.fillRect(j * width, i * height, width, height);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Maze Traversal");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MazeTraversal());
        frame.pack();
        frame.setVisible(true);
    }
}
