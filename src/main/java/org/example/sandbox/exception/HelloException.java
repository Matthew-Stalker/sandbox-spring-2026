package org.example.sandbox.exception;

import java.util.Scanner;

public class HelloException {

    public static void main(String[] args) {
        // try-catch block to handle the exception
        try {
            // do something that may throw an exception
            throw new Exception("Hello, exception!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // do something else

        // try-catch-catch block to handle multiple exceptions
        try {
            // do something that may throw another exception
        } catch (NullPointerException e) {
            System.out.println("Null pointer exception occurred: " + e.getMessage());
        }catch (Exception e) {
            System.out.println("Exception occurred: " + e.getMessage());
        }

        // try-catch-finaly block to handle the exception and execute some code regardless of the exception
        try {
            // do something that may throw an exception
            throw new Exception("Hello, exception in finally block!");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("This will always be executed.");
        }
        // do something else

        try {
            // do something that may throw an exception
        } finally {
            System.out.println("This will always be executed, even if an exception is thrown.");
        }

        //java-7 multi-catch block to handle multiple exceptions in a single catch block
        try {
            // do something that may throw multiple exceptions
        } catch (ArithmeticException | NullPointerException | NumberFormatException e) {
            System.out.println("An exception occurred: " + e.getMessage());
        }

        //try-with-resources block to automatically close resources
        try (Scanner scanner = new Scanner(System.in);
        Scanner anotherscanner = new Scanner(System.in)) {
            //do something with the scanner
        }

        Scanner scanner2 = null;
        try {
            scanner2 = new Scanner(System.in);
            //do something with the scanner
        } finally {
            if (scanner2 != null) {
                scanner2.close();
            }
        }

    }
}
