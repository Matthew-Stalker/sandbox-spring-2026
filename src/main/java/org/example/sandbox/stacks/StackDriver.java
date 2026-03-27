package org.example.sandbox.stacks;

public class StackDriver {

    public static void main(String[] args) {

        Stack<String> stack = new ArrayListStack<>();

        stack.push("a");
        stack.push("b");
        stack.push("c");
        stack.push("d");
        stack.push("e");

        System.out.println(stack);

    }
}
