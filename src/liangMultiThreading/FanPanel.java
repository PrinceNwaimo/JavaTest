package liangMultiThreading;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FanPanel extends JPanel{
    private int fanSpeed = 1; // 0: stopped, 1-4: speed levels
    private int angle = 0;
    private boolean running = false;

    public FanPanel() {
        setPreferredSize(new Dimension(400, 400));
        setBackground(Color.BLACK);
    }

    public void startFan() {
        running = true;
        Thread fanThread = new Thread(() -> {
            while (running) {
                angle = (angle + fanSpeed) % 360;
                repaint();
                try {
                    Thread.sleep(16); // ~60 FPS
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        });
        fanThread.start();
    }

    public void stopFan() {
        running = false;
    }

    public void setFanSpeed(int speed) {
        fanSpeed = speed;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int centerX = getWidth() / 2;
        int centerY = getHeight() / 2;
        int radius = Math.min(centerX, centerY) - 10;

        g2d.setColor(Color.WHITE);
        g2d.fillOval(centerX - radius, centerY - radius, radius * 2, radius * 2);

        for (int i = 0; i < 4; i++) {
            double startAngle = Math.toRadians(angle + i * 90);
            double endAngle = Math.toRadians(angle + i * 90 + 30);
            g2d.setColor(Color.RED);
            g2d.fillArc(centerX - radius, centerY - radius, radius * 2, radius * 2, (int) Math.toDegrees(startAngle), (int) Math.toDegrees(endAngle) - (int) Math.toDegrees(startAngle));
        }
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Running Fan");
        FanPanel fanPanel = new FanPanel();
        frame.add(fanPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

        // Create control buttons
        JPanel controlPanel = new JPanel();
        JButton startButton = new JButton("Start");
        JButton stopButton = new JButton("Stop");
        JButton slowButton = new JButton("Slow");
        JButton fastButton = new JButton("Fast");

        controlPanel.add(startButton);
        controlPanel.add(stopButton);
        controlPanel.add(slowButton);
        controlPanel.add(fastButton);

        frame.add(controlPanel, BorderLayout.SOUTH);

        startButton.addActionListener(e -> {
            fanPanel.startFan();
            fanPanel.setFanSpeed(2);
        });

        stopButton.addActionListener(e -> fanPanel.stopFan());

        slowButton.addActionListener(e -> fanPanel.setFanSpeed(1));

        fastButton.addActionListener(e -> fanPanel.setFanSpeed(4));

        fanPanel.startFan();
    }
}
