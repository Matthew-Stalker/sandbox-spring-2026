package org.example.sandbox.linkedlist;

import java.util.StringJoiner;

public class DoublyLinkedList<E> implements LinkedList<E> {

    private Node head;
    private Node tail;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public void addFirst(E element) {

        Node node = new Node(element, head, null);

        if (head == null) {
            head = node;
            tail = head;
        } else {
            head.previous = node;
            head = node;
        }

    }

    @Override
    public void addLast(E element) {

        Node node = new Node(element, null, tail);
        tail.next = node;
        tail = node;

    }

    @Override
    public E pollFirst() {

        E element;
        if (head == null) {
            element = null;
        } else {

            element = head.element;

            if (head == tail) {
                head = null;
                tail = null;
            } else {
                Node next = head.next;
                head.next = null;
                head = next;
                head.previous = null;
            }
        }

        return element;
    }

    @Override
    public E pollLast() {

        E element;
        if (tail == null) {
            element = null;
        } else {

            element = tail.element;

            if (head == tail) {
                head = null;
                tail = null;
            } else {
                Node newTail = tail.previous;
                tail.previous = null;
                newTail.next = null;
                tail = newTail;
            }
        }
        return element;
    }

    @Override
    public E peekFirst() {
        return head.element;
    }

    @Override
    public E peekLast() {
        return tail.element;
    }

    @Override
    public void clear() {

        Node current = head;
        while (current.next != null) {

            Node next = current.next;
            current.next = null; // breaks forward reference
            current.previous = null; // breaks backward reference
            current = next;
        }

        head = null;
        tail = null;
    }

    @Override
    public boolean contains(E element) {

        boolean contains = false;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            if (current.element == element) {
                contains = true;
                break;
            }
            current = next;
        }
        return contains;
    }

    @Override
    public int size() {

        int counter = 0;
        if (head != null) {

            if(head == tail) {
                counter = 1;
            } else {
                Node current = head;
                while(current != null){
                    counter++;
                    current = current.next;
                }
            }
        }
        return counter;
    }

    public String toString() {

        StringBuilder builder = new StringBuilder("[");
        StringJoiner joiner = new StringJoiner(", ");
        Node current = head;
        if (current != null) {

            while (current != null) {
                joiner.add(current.element.toString());
                current = current.next;
            }
        }
        builder.append(joiner.toString());
        builder.append("]");
        return builder.toString();
    }

    public String reverseToString() {

        StringBuilder builder = new StringBuilder("[");
        StringJoiner joiner = new StringJoiner(", ");
        Node current = tail;
        if (current != null) {

            while (current != null) {
                joiner.add(current.element.toString());
                current = current.previous;
            }
        }
        builder.append(joiner);
        builder.append("]");
        return builder.toString();
    }

    private class Node {

        E element;
        Node next;
        Node previous;

        public Node(E element, Node next, Node previous) {
            this.element = element;
            this.next = next;
            this.previous = previous;
        }

    }
}