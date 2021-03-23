
// **************************************************************** 
// PrimePanel.java 
// 
// Represents the panel for a program that displays all primes 
// up to a number input by the user. 
// **************************************************************** 
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PrimePanel extends JPanel {
    private JTextField number;
    private JButton computeButton;
    private JTextArea primeList;
    private JLabel errorLabel;

    // ----------------------------------------------------------
    // Sets up a panel with a heading, a labeled text field
    // for the user to enter an integer, a button to trigger
    // the calculation, and a text area to display the list
    // of primes.
    // ----------------------------------------------------------
    public PrimePanel() {
        JLabel heading = new JLabel("Prime Number Listing");
        heading.setFont(new Font("Helvetica", Font.BOLD, 30));

        errorLabel = new JLabel();

        JLabel inputLabel = new JLabel("Enter a number: ");
        number = new JTextField(8);
        computeButton = new JButton("Click to see all primes up to your number!");

        primeList = new JTextArea(10, 30);
        JScrollPane primeListPane = new JScrollPane(primeList);
        primeListPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        computeButton.addActionListener(new ButtonListener());
        // Add the components to the panel
        add(heading);
        add(errorLabel);
        add(inputLabel);
        add(number);
        add(computeButton);
        add(primeListPane);
        setPreferredSize(new Dimension(400, 320));
        setBackground(Color.yellow);
    }

    private Boolean isPrime(int numberToCheck) {
        if (numberToCheck <= 3) {
            return numberToCheck > 1;
        } else if (numberToCheck % 2 == 0 || numberToCheck % 3 == 0) {
            return false;
        }

        int i = 5;
        while (Math.pow(i, 2) <= numberToCheck) {
            if (numberToCheck % i == 0 || numberToCheck % (i + 2) == 0) {
                return false;
            }

            i += 6;
        }

        return true;
    }

    // *****************************************************************
    // Represents a listener for the click of the button.
    // *****************************************************************
    public class ButtonListener implements ActionListener {
        // -----------------------------------------------------------
        // Generates and displays a list of primes when the
        // button is clicked.
        // -----------------------------------------------------------
        public void actionPerformed(ActionEvent event) {
            String textNum = number.getText();
            try {
                int num = Integer.parseInt(textNum);
                errorLabel.setText("");

                String ans = "";
                int count = 0;
                if (num < 2)
                    ans = "There no primes less than " + num;
                else {
                    ans = " " + 2;
                    count++;
                    for (int i = 3; i <= num; i += 2) {
                        // Add i to the list if it is prime
                        if (isPrime(i)) {
                            ans += " " + i;
                            count++;
                            if (count % 10 == 0)
                                ans += "\n";
                        }
                    }
                }
                primeList.setText(ans);
            } catch (NumberFormatException e) {
                errorLabel.setText("Input is not integer!");
            }
        }
    }
}