package org.example.sandbox.exception;

public class Calculator {

    public int divide(int a, int b) throws DivideByZeroException {

        int result = Integer.MIN_VALUE;
        try {
            result =  a / b;
        } catch (ArithmeticException e) {
            System.out.println("ArithmeticException caught: " + e.getMessage());
            throw new  DivideByZeroException("Cannot divide by zero", e);
        }
        return result;

    }

    public int safeDivide(int a, int b) {

        try {
            return divide(a, b);
        } catch (DivideByZeroException e) {
            e.printStackTrace();
        }
        return 0;

    }

    public static void main(String[] args) {

        Calculator calculator = new Calculator();

        int result1 = calculator.safeDivide(10, 2);
        System.out.println("Result of 10 / 2: " + result1);

        int result2 = calculator.safeDivide(10, 0);
        System.out.println("Result of 10 / 0: " + result2);

    }
}
