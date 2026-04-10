package org.example.sandbox.reccursion.stackoverflow;

public class Demo {

    public static void main(String[] args) {

        Demo demo = new Demo();
        demo.plus(1);
    }

    private int plus(int i) {

        System.out.println(i);
        return plus(i + 1);
    }
}
