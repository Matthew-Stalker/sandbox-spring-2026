package org.example.sandbox.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ArrayListStack<T> implements Stack<T> {

    private List<T> stack;

    public ArrayListStack() {
        stack = new ArrayList<>() {

            // anonymous class -> what lambdas replaced
            @Override
            public String toString() {

                final StringBuilder sb = new StringBuilder();
                for (T t : stack) {
                    sb.append(t).append("\n");
                }
                return sb.toString();
            }
        };
    }

    @Override
    public boolean empty() {
        return this.stack.isEmpty();
    }

    @Override
    public T peek() {
        return this.stack.getFirst();
    }

    @Override
    public T pop() {
        return this.stack.removeFirst();
    }

    @Override
    public T push(T t) {
        this.stack.addFirst(t); // add
        return peek(); // peek
    }

    @Override
    public int search(T t) {

        int index = this.stack.indexOf(t);
        return (index == -1) ? index : index + 1;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ArrayListStack<?> that = (ArrayListStack<?>) o;
        return Objects.equals(stack, that.stack);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(stack);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append(stack);
        /*for (T t : stack) {
            sb.append(t).append("\n");
        }
        */
        return sb.toString();
    }
}