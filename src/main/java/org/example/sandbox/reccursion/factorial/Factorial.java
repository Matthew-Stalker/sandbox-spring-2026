package org.example.sandbox.reccursion.factorial;

import java.math.BigInteger;

public class Factorial {
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++) {
            System.out.println("Factorial of " + i + " is " + factorial(i));
        }

    }

    private static BigInteger factorial(int i) {
        if (i == 0) {
            return BigInteger.ONE;
        }

        return factorial(i-1).multiply(BigInteger.valueOf(i));
    }
}
