/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

/**
 *
 * @author Sami
 */
public class Calculator {
    
    /**
     *@param operation the math operation to calculate given by symbolic string i.e. "+" 
     *@param a the current result of operation chain, the first factor
     *@param b the second factor of the operation
     */
    public static double calculate(String operation, double a, double b) {
        if (operation.equals("+")) {
            return add(a, b);
        }
        if (operation.equals("-")) {
            return subtract(a, b);
        }
        if (operation.equals("*")) {
            return multiply(a, b);
        }
        if (operation.equals("/")) {
            return divide(a, b);
        }
        else return a;
    }
    
    //summa
    private static double add(double a, double b) {
       return 0;
    }
    
    //erotus
    private static double subtract(double a, double b) {
        return 0;
    }
    
//    jakolasku
    private static double divide(double a, double b) {
        return 0;
    }
    
//    tulo
    private static double multiply(double a, double b) {
        return 0;
    }
}
