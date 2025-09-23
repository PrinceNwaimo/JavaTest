package diettelGenerics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorChooserApp extends JPanel {
    private Color currentColor = Color.BLACK;

    public ColorChooserApp() {
        String[] colorNames = ColorChooser.getColorNames();
        JComboBox<String> colorComboBox = new JComboBox<>(colorNames);
        colorComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String selectedColorName = (String) colorComboBox.getSelectedItem();
                currentColor = ColorChooser.getColor(selectedColorName);
            }
        });

        JButton drawButton = new JButton("Draw");
        drawButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });

        add(colorComboBox);
        add(drawButton);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(currentColor);
        g.fillOval(100, 100, 200, 200);
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Color Chooser App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new ColorChooserApp());
        frame.setSize(400, 400);
        frame.setVisible(true);
    }
}
