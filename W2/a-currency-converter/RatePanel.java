
// ******************************************************************
// RatePanel.java
//
// Panel for a program that converts different currencies to
// U.S. Dollars
// ******************************************************************
import java.awt.*;
import java.awt.event.*;
import java.text.NumberFormat;

import javax.swing.*;
import javax.swing.text.NumberFormatter;

public class RatePanel extends JPanel {
    private double[] rate; // exchange rates
    private String[] currencyName;
    private JLabel result;
    private JComboBox<String> currencyComboBox;
    private JTextField amountField;

    // ------------------------------------------------------------
    // Sets up a panel to convert cost from one of 6 currencies
    // into U.S. Dollars. The panel contains a heading, a text
    // field for the cost of the item, a combo box for selecting
    // the currency, and a label to display the result.
    // ------------------------------------------------------------
    public RatePanel() {
        setLayout(new BorderLayout());

        JPanel titlePanel = new JPanel();
        titlePanel.setLayout(new BorderLayout());

        JLabel title = new JLabel("How much is that in dollars?");
        title.setAlignmentX(Component.CENTER_ALIGNMENT);
        title.setFont(new Font("Helvetica", Font.BOLD, 20));

        // Set up the arrays for the currency conversions
        currencyName = new String[] { "Select the currency..", "European Euro", "Canadian Dollar", "Japanese Yen",
                "Australian Dollar", "Indian Rupee", "Mexican Peso" };
        rate = new double[] { 0.0, 1.2103, 0.7351, 0.0091, 0.6969, 0.0222, 0.0880 };
        result = new JLabel(" ------------ ");

        titlePanel.add(title, "North");
        titlePanel.add(result, "South");
        add(titlePanel, "North");

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());

        currencyComboBox = new JComboBox<>(currencyName);
        currencyComboBox.addActionListener(new ComboListener());

        JPanel amountPanel = new JPanel();
        amountPanel.setLayout(new BorderLayout());

        amountField = new JTextField("0", 16);
        amountField.addActionListener(new ComboListener());

        JLabel amountLabel = new JLabel("Amount : ");

        amountPanel.add(amountField, "East");
        amountPanel.add(amountLabel, "West");

        inputPanel.add(amountPanel, "West");
        inputPanel.add(currencyComboBox, "East");

        add(inputPanel, "South");
    }

    // ******************************************************
    // Represents an action listener for the combo box.
    // ******************************************************
    private class ComboListener implements ActionListener {
        // --------------------------------------------------
        // Determines which currency has been selected and
        // the value in that currency then computes and
        // displays the value in U.S. Dollars.
        // --------------------------------------------------
        public void actionPerformed(ActionEvent event) {
            int index = currencyComboBox.getSelectedIndex();

            result.setText(Integer.parseInt(amountField.getText()) * rate[index] + " U.S. Dollars");
        }
    }
}