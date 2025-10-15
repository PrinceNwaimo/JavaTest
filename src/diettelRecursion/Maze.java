package diettelRecursion;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Maze extends JPanel {
    private char[][] maze;
    private int startX, startY, endX, endY;
    private int width, height;

    public Maze(int width, int height) {
        this.width = width;
        this.height = height;
        maze = new char[height][width];
        generateMaze();
        solveMaze(startX, startY);
        setPreferredSize(new Dimension(width * 20, height * 20));
    }

    private void generateMaze() {
        Random random = new Random();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == 0 || j == 0 || i == height - 1 || j == width - 1) {
                    maze[i][j] = '#';
                } else if (random.nextDouble() < 0.2) {
                    maze[i][j] = '#';
                } else {
                    maze[i][j] = '.';
                }
            }
        }
        startX = random.nextInt(height - 2) + 1;
        startY = random.nextInt(width - 2) + 1;
        maze[startX][startY] = '.';
        endX = random.nextInt(height - 2) + 1;
        endY = random.nextInt(width - 2) + 1;
        while (endX == startX && endY == startY) {
            endX = random.nextInt(height - 2) + 1;
            endY = random.nextInt(width - 2) + 1;
        }
        maze[endX][endY] = '.';
    }

    private boolean solveMaze(int x, int y) {
        if (x < 0 || x >= height || y < 0 || y >= width || maze[x][y] == '#' || maze[x][y] == '0') {
            return false;
        }
        if (x == endX && y == endY) {
            maze[x][y] = 'E';
            repaint();
            return true;
        }
        maze[x][y] = 'x';
        repaint();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        if (solveMaze(x + 1, y) || solveMaze(x - 1, y) || solveMaze(x, y + 1) || solveMaze(x, y - 1)) {
            return true;
        }
        maze[x][y] = '.';
        repaint();
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
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
                    case 'E':
                        g.setColor(Color.YELLOW);
                        break;
                }
                g.fillRect(j * 20, i * 20, 20, 20);
            }
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Maze");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new Maze(40, 20));
        frame.pack();
        frame.setVisible(true);
    }
}
