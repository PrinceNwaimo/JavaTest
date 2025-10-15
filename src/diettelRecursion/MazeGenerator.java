package diettelRecursion;

import javax.swing.*;
import java.awt.*;
import java.util.Random;


public class MazeGenerator extends JPanel {
    private char[][] maze = new char[12][12];
    private int startX, startY, endX, endY;
    private boolean solved = false;

    public MazeGenerator() {
        generateMaze();
        solveMaze(startX, startY);
        setPreferredSize(new Dimension(600, 600));
    }

    private void generateMaze() {
        Random random = new Random();
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (i == 0 || j == 0 || i == maze.length - 1 || j == maze[i].length - 1) {
                    maze[i][j] = '#';
                } else if (random.nextDouble() < 0.2) {
                    maze[i][j] = '#';
                } else {
                    maze[i][j] = '.';
                }
            }
        }
        startX = random.nextInt(maze.length - 2) + 1;
        startY = random.nextInt(maze[0].length - 2) + 1;
        maze[startX][startY] = '.';
        endX = random.nextInt(maze.length - 2) + 1;
        endY = random.nextInt(maze[0].length - 2) + 1;
        maze[endX][endY] = '.';
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
        JFrame frame = new JFrame("Maze Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new MazeGenerator());
        frame.pack();
        frame.setVisible(true);
    }
}
