package org.example.sandbox.exception;

public class Calculator {

    public int divide(int a, int b) {
        if (b == 0) {
            throw new DivideByZeroException("Cannot divide by zero.");
        }
        return a / b;
    }

    public int safeDivide(int a, int b) {
        try {
            return divide(a, b);
        } catch (DivideByZeroException e) {
            System.out.println(e.getMessage());
            return 0; // or some default value
        }
    }
}
