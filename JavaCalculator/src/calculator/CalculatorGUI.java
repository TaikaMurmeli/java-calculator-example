/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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
    private List<String> operatorButtonNames = Arrays.asList(
            "+",
            "-",
            "*",
            "/",
            "=");
    private ButtonListener buttonListener = new ButtonListener(this);

    public CalculatorGUI() {
        JPanel numberPanel = new JPanel();
        JPanel textPanel = new JPanel();
        JPanel operatorPanel = new JPanel();

        numberPanel.setLayout(new GridLayout(4, 3));
        operatorPanel.setLayout(new GridLayout(5, 1));

        resultText.setEditable(false);
        inputText.setEditable(false);

        addButtons(numberPanel, operatorPanel);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(inputText, BorderLayout.NORTH);
        mainPanel.add(numberPanel, BorderLayout.WEST);
        mainPanel.add(operatorPanel, BorderLayout.EAST);
        mainPanel.add(resultText, BorderLayout.SOUTH);

        add(mainPanel);
    }

    public Map<String, JButton> getButtons() {
        return buttons;
    }
    
    public void setInputText(String input) {
        inputText.setText(input);
    }
    
    public void setResultText(String result) {
        resultText.setText(result);
    }

    private void addButtons(JPanel numberPanel, JPanel operatorPanel) {
        for (int i = 0; i < 10; i++) {
            createButton("" + i, numberPanel);
        }
        createButton("C", numberPanel);
        operatorButtonNames.forEach((bname) -> createButton(bname, operatorPanel));
    }
    
    private void createButton(String name, JPanel panel) {
        JButton button = new JButton(name);
        buttons.put(name, button);
        button.addActionListener(buttonListener);
        panel.add(button);
    }
}
