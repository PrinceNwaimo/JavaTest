package liangMultiThreading;

import javax.swing.*;
import java.awt.*;
import java.util.Calendar;
//import java.util.Gitea;

public class ClockPane extends JPanel{
    private int hour;
    private int minute;
    private int second;
    private boolean running = false;

    public ClockPane() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.WHITE);
    }

    public void startClock() {
        running = true;
        Thread clockThread = new Thread(() -> {
            while (running) {
                Calendar calendar = Calendar.getInstance();
                hour = calendar.get(Calendar.HOUR_OF_DAY);
                minute = calendar.get(Calendar.MINUTE);
                second = calendar.get(Calendar.SECOND);
                repaint();
                try {
                    Thread.sleep(1000); // Update every second
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        clockThread.start();
    }

    public void stopClock() {
        running = false;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = Math.min(centerX, centerY) - 10;

        // Draw clock face
        g2d.setColor(Color.BLACK);
        g2d.drawOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

        // Draw hour hand
        double hourAngle = Math.toRadians((hour % 12 + minute / 60.0) * 30);
        int hourX = centerX + (int) (radius * 0.5 * Math.sin(hourAngle));
        int hourY = centerY - (int) (radius * 0.5 * Math.cos(hourAngle));
        g2d.setStroke(new BasicStroke(4));
        g2d.drawLine(centerX, centerY, hourX, hourY);

        // Draw minute hand
        double minuteAngle = Math.toRadians((minute + second / 60.0) * 6);
        int minuteX = centerX + (int) (radius * 0.8 * Math.sin(minuteAngle));
        int minuteY = centerY - (int) (radius * 0.8 * Math.cos(minuteAngle));
        g2d.setStroke(new BasicStroke(2));
        g2d.drawLine(centerX, centerY, minuteX, minuteY);

        // Draw second hand
        double secondAngle = Math.toRadians(second * 6);
        int secondX = centerX + (int) (radius * 0.9 * Math.sin(secondAngle));
        int secondY = centerY - (int) (radius * 0.9 * Math.cos(secondAngle));
        g2d.setColor(Color.RED);
        g2d.setStroke(new BasicStroke(1));
        g2d.drawLine(centerX, centerY, secondX, secondY);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Clock");
        ClockPane clockPane = new ClockPane();
        frame.add(clockPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        clockPane.startClock();
    }
}
