package liangMultiThreading;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class BallPane extends JPanel {
    private ArrayList<Ball> balls = new ArrayList<>();
    private boolean running = false;

    public BallPane() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
    }

    public void addBall() {
        balls.add(new Ball());
    }

    public void startAnimation() {
        running = true;
        Thread animationThread = new Thread(() -> {
            while (running) {
                for (Ball ball : balls) {
                    ball.move(getWidth(), getHeight());
                }
                repaint();
                try {
                    Thread.sleep(16); // ~60 FPS
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        animationThread.start();
    }

    public void stopAnimation() {
        running = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        for (Ball ball : balls) {
            g.setColor(ball.getColor());
            g.fillOval((int) ball.getX(), (int) ball.getY(), ball.getRadius() * 2, ball.getRadius() * 2);
        }
    }

    private static class Ball {
        private double x, y;
        private double dx, dy;
        private int radius;
        private Color color;

        public Ball() {
            x = Math.random() * 200 + 100;
            y = Math.random() * 200 + 100;
            dx = Math.random() * 4 - 2;
            dy = Math.random() * 4 - 2;
            radius = (int) (Math.random() * 20 + 10);
            color = new Color((int) (Math.random() * 256), (int) (Math.random() * 256), (int) (Math.random() * 256));
        }

        public void move(int width, int height) {
            x += dx;
            y += dy;

            if (x < 0 || x > width - radius * 2) {
                dx = -dx;
            }
            if (y < 0 || y > height - radius * 2) {
                dy = -dy;
            }
        }

        public double getX() {
            return x;
        }

        public double getY() {
            return y;
        }

        public int getRadius() {
            return radius;
        }

        public Color getColor() {
            return color;
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Bouncing Balls");
        BallPane ballPane = new BallPane();
        frame.add(ballPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Add balls and start animation
        ballPane.addBall();
        ballPane.addBall();
        ballPane.startAnimation();
    }
}
