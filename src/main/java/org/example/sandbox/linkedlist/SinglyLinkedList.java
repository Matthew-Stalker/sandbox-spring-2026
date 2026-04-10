package org.example.sandbox.linkedlist;

import java.util.StringJoiner;

public class SinglyLinkedList<E> implements LinkedList<E> {

    private Node head;
    private Node tail;
    private int size;

    public SinglyLinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    // 0(1)
    @Override
    public void addFirst(E element) {

        Node newNode = new Node(element, head);

        if (head == null) { // Empty List
            head = newNode;
            tail = newNode;
        } else {
            head = newNode;
        }
        this.size++;

    }

    // 0(1)
    @Override
    public void addLast(E element) {

        Node newNode = new Node(element, null);

        if (tail == null) {
            tail = newNode;
            head = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        this.size++;


    }

    // 0(1)
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
            }
        }
        this.size--;
        return element;

    }

    // 0(n)
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
                element = tail.element;

                if (tail == head) {
                    head = null;
                    tail = null;
                } else {
                    Node current = head;
                    Node previous = head;

                    while (current.next != tail) { // O(n)
                        previous = current;
                        current = current.next;
                    }

                    tail = previous;
                    tail.next = null;
                }
            }
        }
        this.size--;
        return element;
    }

    // 0(1)
    @Override
    public E peekFirst() {
        return this.head.element;
    }

    // 0(1)
    @Override
    public E peekLast() {
        return this.tail.element;
    }

    // 0(n)
    @Override
    public void clear() {

        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = null;
            current = next;
        }
        head = null;
        tail = null;
        this.size = 0;
    }

    // 0(n)
    @Override
    public boolean contains(E element) {

        boolean contains = false;

        Node current = head;

        while (current != element) {
            if (current.element.equals(element)) {
                contains = true;
                break;
            }
            current = current.next;
        }
        return contains;
    }

    // 0(1)
    @Override
    public int size() {
        return this.size;
    }

    private class Node {

        E element;
        Node next;

        public Node(E element, Node next) {
            this.element = element;
            this.next = next;
        }
    }

    // 0(n^2)
    @Override
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
        builder.append(joiner);
        builder.append("]");
        return builder.toString();

    }

}
