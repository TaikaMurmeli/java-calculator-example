
package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.JButton;

/**
 *
 * @author Sami
 */
public class CalculatorListener implements ActionListener {

    private CalculatorGUI calculatorGUI;
    private Map<String, JButton> buttons;
    private double result = 0;
    private String input = "";
    private String tempInput = "";
    private String previousOperation = "";

    public CalculatorListener(CalculatorGUI calculatorGUI) {
        this.calculatorGUI = calculatorGUI;
        buttons = calculatorGUI.getButtons();
    }

    public void actionPerformed(ActionEvent ae) {
        String button = getClickedButton(ae);
        setFirstFactor();
        if (isANumber(button)) {
            updateInput(button);
        } else if (isADot(button)) {
            if (!tempInput.contains(".")) {
                updateInput(button);
            }
        } else {
            performOperation(button);
        }
    }

    private void updateInput(String button) {
        input += button;
        tempInput += button;
        calculatorGUI.setInputText(input);
    }

    private String getClickedButton(ActionEvent ae) {
        String clickedButton = "";
        for (String button : buttons.keySet()) {
            if (buttons.get(button) == ae.getSource()) {
                clickedButton = button;
            }
        }
        return clickedButton;
    }

    private boolean isADot(String s) {
        if (s.equals(".")) {
            return true;
        }
        return false;
    }

    private boolean isANumber(String s) {
        try {
            Double.parseDouble(s);
            return true;
        } catch (Exception e) {
            //Not a number button
            return false;
        }
    }

    /**
     * If the input consists of only integers we have our first factor of a math
     * operation.
     */
    private void setFirstFactor() {
        try {
            double i = Double.parseDouble(input);
            result = i;
        } catch (Exception e) {
        }
    }

    private void updateInputAndOutput(String operation) {
        if (operation.equals("C")) {
            input = "";
            result = 0;
            calculatorGUI.setInputText(input);
            calculatorGUI.setResultText("" + result);
        }
        //prevent stacking operators
        if (input.isEmpty()
                || !isANumber(""+input.charAt(input.length() - 1))
                && !isADot(""+input.charAt(input.length() - 1))) {
            return;
        }

        if (!operation.equals("=")) {
            input += operation;
        }

        tempInput = "";

        calculatorGUI.setInputText(input);
        calculatorGUI.setResultText("" + result);

        if (operation.equals("=")) {
            input = "";
        }
    }

    private void performOperation(String button) {
//        if the previous button clicked was a number,
//        we may update the result.
        if (!tempInput.isEmpty()) {
            if (tempInput.contains(".")) {
                tempInput += "0";
            }
            result = Calculator.calculate(previousOperation, result, Double.parseDouble(tempInput));
        }
        updateInputAndOutput(button);
        previousOperation = button;
    }
}
