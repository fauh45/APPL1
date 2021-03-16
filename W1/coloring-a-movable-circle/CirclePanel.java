
// ******************************************************************
// CirclePanel.java
//
// A panel with a circle drawn in the center and buttons on the
// bottom that move the circle.
// ******************************************************************
import java.awt.*;
import javax.swing.*;

import java.awt.event.*;

public class CirclePanel extends JPanel {
    private final int CIRCLE_SIZE = 50;
    private int x, y;
    private Color c;

    private JColorChooser colorChooser;
    private JButton selectColor;

    // ---------------------------------------------------------------
    // Set up circle and buttons to move it.
    // ---------------------------------------------------------------
    public CirclePanel(int width, int height) {
        // Set coordinates so circle starts in middle
        x = (width / 2) - (CIRCLE_SIZE / 2);
        y = (height / 2) - (CIRCLE_SIZE / 2);
        c = Color.green;
        // Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());
        // Create buttons to move the circle
        JButton left = new JButton("Left");
        JButton right = new JButton("Right");
        JButton up = new JButton("Up");
        JButton down = new JButton("Down");

        // Creates button to change color
        JButton pink = new JButton("Pink");
        colorChooser = new JColorChooser(c);
        selectColor = new JButton("Choose Color");
        JButton green = new JButton("Green");

        Color pinkColor = new Color(255, 182, 193);

        pink.setBackground(pinkColor);
        green.setBackground(Color.GREEN);

        pink.addActionListener(new ColorListener(pinkColor));
        selectColor.addActionListener(new ColorListener(null));
        green.addActionListener(new ColorListener(Color.GREEN));

        // Add listeners to the buttons
        left.addActionListener(new MoveListener(-20, 0));
        right.addActionListener(new MoveListener(20, 0));
        up.addActionListener(new MoveListener(0, -20));
        down.addActionListener(new MoveListener(0, 20));
        // Need a panel to put the buttons on or they'll be on
        // top of each other.
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);

        JPanel colorPanel = new JPanel();
        colorPanel.add(pink);
        colorPanel.add(selectColor);
        colorPanel.add(green);

        // Add the button panel to the bottom of the main panel
        this.add(buttonPanel, "South");
        this.add(colorPanel, "North");
    }

    // ---------------------------------------------------------------
    // Draw circle on CirclePanel
    // ---------------------------------------------------------------
    public void paintComponent(Graphics page) {

        super.paintComponent(page);
        page.setColor(c);
        page.fillOval(x, y, CIRCLE_SIZE, CIRCLE_SIZE);
    }

    // ---------------------------------------------------------------
    // Class to listen for button clicks that move circle.
    // ---------------------------------------------------------------
    private class MoveListener implements ActionListener {
        private int dx;
        private int dy;

        // ---------------------------------------------------------------
        // Parameters tell how to move circle at click.
        // ---------------------------------------------------------------
        public MoveListener(int dx, int dy) {
            this.dx = dx;
            this.dy = dy;
        }

        // ---------------------------------------------------------------
        // Change x and y coordinates and repaint.
        // ---------------------------------------------------------------
        public void actionPerformed(ActionEvent e) {
            x += dx;
            y += dy;
            repaint();
        }
    }

    private class ColorListener implements ActionListener {
        private Color nC;

        public ColorListener(Color c) {
            this.nC = c;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (nC == null) {
                nC = colorChooser.showDialog(selectColor, "Choose color", c);
            }

            c = nC;
            repaint();
        }
    }
}