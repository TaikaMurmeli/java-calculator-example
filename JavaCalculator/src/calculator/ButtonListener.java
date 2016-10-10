/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;

/**
 *
 * @author Sami
 */
public class ButtonListener implements ActionListener {
    
    private CalculatorGUI calculatorGUI;
    private Map<String, JButton> buttons;
    private double result = 0;
    private String input = "";
    private String tempInput = "";
    private String previousOperation = "";

    public ButtonListener(CalculatorGUI calculatorGUI) {
        this.calculatorGUI = calculatorGUI;
        buttons = calculatorGUI.getButtons();
    }
    
    public void actionPerformed(ActionEvent ae) {
        String button = getClickedButton(ae);
        setFirstFactor();
        if(buttonIsNumber(button)) {
            input += button;
            tempInput += button;
            calculatorGUI.setInputText(input);   
            return;
        }
        performOperation(button);
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
    
    private boolean buttonIsNumber(String button) {
        try {
            Integer.parseInt(button);
            return true;
        } catch (Exception e) {
            //Not a number button
            return false;           
        }
    }
    
    /**
     *If the input consists of only integers
     *we have our first factor of a math operation.
     */
    private void setFirstFactor() {
        try {
            int i = Integer.parseInt(input);
            result = i;
            System.out.println(result);
        } catch (Exception e) {
        }
    }
    
    private void applyOperation(String operation) {     
        if (operation.equals("C")) {
            input = "";
            result = 0;
        } else if(!operation.equals("=")){
            input += operation;
        }
        
        tempInput = "";
        previousOperation = operation;
        
        calculatorGUI.setInputText(input);
        calculatorGUI.setResultText("" + result);
        
        if (operation.equals("=")) {
            input = "";
        }
    }
    
    private void performOperation(String button) {
        //if the previous button clicked was a number we may update the result 
        if (!tempInput.isEmpty()) {
            result = Calculator.calculate(previousOperation, result, Double.parseDouble(tempInput));
        }
        buttons.forEach((k,v) -> {if(k.equals(button)) applyOperation(button);});
    }
}
