
// ****************************************************************** 
// CirclePanel.java 
// 
// A panel with a circle drawn in the center and buttons on the 
// bottom that move the circle. 
// ****************************************************************** 
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

enum Direction {
    LEFT, RIGHT, UP, DOWN
}

public class CirclePanel extends JPanel {
    private final int CIRCLE_SIZE = 50;
    private int x, y;
    private int height, width;
    private Color c;

    private JButton left;
    private JButton right;
    private JButton up;
    private JButton down;

    // ---------------------------------------------------------------
    // Set up circle and buttons to move it.
    // ---------------------------------------------------------------
    public CirclePanel(int width, int height) {
        this.height = height;
        this.width = width;

        // Set coordinates so circle starts in middle
        x = (width / 2) - (CIRCLE_SIZE / 2);
        y = (height / 2) - (CIRCLE_SIZE / 2);
        c = Color.green;

        // Need a border layout to get the buttons on the bottom
        this.setLayout(new BorderLayout());

        // Create buttons to move the circle
        left = new JButton("Left");
        right = new JButton("Right");
        up = new JButton("Up");
        down = new JButton("Down");

        left.setMnemonic(KeyEvent.VK_L);
        right.setMnemonic(KeyEvent.VK_R);
        up.setMnemonic(KeyEvent.VK_U);
        down.setMnemonic(KeyEvent.VK_D);

        // Add listeners to the buttons
        left.addActionListener(new MoveListener(-20, 0, Direction.LEFT));
        right.addActionListener(new MoveListener(20, 0, Direction.RIGHT));
        up.addActionListener(new MoveListener(0, -20, Direction.UP));
        down.addActionListener(new MoveListener(0, 20, Direction.DOWN));

        // Need a panel to put the buttons on or they'll be on
        // top of each other.
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(left);
        buttonPanel.add(right);
        buttonPanel.add(up);
        buttonPanel.add(down);

        // Add the button panel to the bottom of the main panel
        this.add(buttonPanel, "South");
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
        private int used;
        private Direction buttonDirection;

        // ---------------------------------------------------------------
        // Parameters tell how to move circle at click.
        // ---------------------------------------------------------------
        public MoveListener(int dx, int dy, Direction buttonDirection) {
            this.buttonDirection = buttonDirection;
            this.used = 0;

            this.dx = dx;
            this.dy = dy;

            this.setButtonUsed();
        }

        private void setButtonUsed() {
            switch (this.buttonDirection) {
            case LEFT:
                left.setToolTipText("Move the ball down, has moved the ball " + dx * used + " points");
                break;

            case RIGHT:
                right.setToolTipText("Move the ball down, has moved the ball " + dx * used + " points");
                break;

            case UP:
                up.setToolTipText("Move the ball down, has moved the ball " + dy * used + " points");
                break;

            case DOWN:
                down.setToolTipText("Move the ball down, has moved the ball " + dy * used + " points");
                break;

            default:
                break;
            }
        }

        // NOTE: Using constants as the heigth and width is not consistent
        private void checkAndSetDisableButtons() {
            up.setEnabled(y > 24);
            down.setEnabled(y < 164);
            left.setEnabled(x > 34);
            right.setEnabled(x < 295);
        }

        // ---------------------------------------------------------------
        // Change x and y coordinates and repaint.
        // ---------------------------------------------------------------
        public void actionPerformed(ActionEvent e) {
            System.out.println("x : " + x + " y : " + y);

            used += 1;
            this.setButtonUsed();

            this.checkAndSetDisableButtons();

            x += dx;
            y += dy;
            repaint();
        }
    }
}