
package calculator;

import java.awt.Dimension;
import javax.swing.JFrame;

/**
 *
 * @author Sami
 */
public class JavaCalculator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(Double.parseDouble(".1"));
        CalculatorGUI calculator = new CalculatorGUI();
        calculator.pack();
        calculator.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        calculator.setLocationRelativeTo(null);
        calculator.setVisible(true);
    }
}
