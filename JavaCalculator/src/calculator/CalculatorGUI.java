
package calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author Sami Sarsa
 */
public class CalculatorGUI extends JFrame {

    private JTextField resultText = new JTextField();
    private JTextField inputText = new JTextField();
    private Map<String, JButton> buttons = new HashMap<String, JButton>();
    private List<String> operatorButtonSymbols = Arrays.asList(
            "+",
            "-",
            "*",
            "/",
            "=");
    private CalculatorListener calculatorListener = new CalculatorListener(this);

    public CalculatorGUI() {
        JPanel numberPanel = new JPanel();
        JPanel operatorPanel = new JPanel();

        numberPanel.setLayout(new GridLayout(4, 3));
        operatorPanel.setLayout(new GridLayout(5, 1));

        setTextFieldProperties(inputText);
        setTextFieldProperties(resultText);

        addButtons(numberPanel, operatorPanel);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(inputText, BorderLayout.NORTH);
        mainPanel.add(numberPanel, BorderLayout.WEST);
        mainPanel.add(operatorPanel, BorderLayout.EAST);
        mainPanel.add(resultText, BorderLayout.SOUTH);

        this.add(mainPanel);
    }

    public Map<String, JButton> getButtons() {
        return buttons;
    }

    public void setInputText(String input) {
        inputText.setText(input);
    }

    public void setResultText(String result) {
        try {
            double resultValue = Double.parseDouble(result);
            if (resultValue % 1 == 0) {
                result = "" + (long) resultValue;
            }
        } catch (Exception e) {
        }
        resultText.setText(result);
    }

    private void addButtons(JPanel numberPanel, JPanel operatorPanel) {
        for (int i = 1; i < 10; i++) {
            createButton("" + i, numberPanel);
        }
        createButton("0", numberPanel);
        createButton("C", numberPanel);
        createButton(".", numberPanel);
        operatorButtonSymbols.forEach((symbol) -> createButton(symbol, operatorPanel));
    }

    private void createButton(String name, JPanel panel) {
        JButton button = new JButton(name);
        button.setPreferredSize(new Dimension(100, 100));
        buttons.put(name, button);
        button.addActionListener(calculatorListener);
        panel.add(button);
    }

    private void setTextFieldProperties(JTextField textField) {
        textField.setEditable(false);
        textField.setPreferredSize(new Dimension(100, 100));
        textField.setFont(new Font("Arial", Font.PLAIN, 40));
    }
}
