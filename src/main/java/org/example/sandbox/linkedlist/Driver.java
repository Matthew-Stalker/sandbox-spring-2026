package org.example.sandbox.linkedlist;

public class Driver {

    public static void main(String[] args) {

        LinkedList<String> linkedList = new SinglyLinkedList<>();

        linkedList.addFirst("One");
        linkedList.addFirst("Two");
        linkedList.addFirst("Three");
        linkedList.addFirst("Four");
        linkedList.addFirst("Five");

        linkedList.addLast("Six");
        linkedList.addLast("Seven");
        linkedList.addLast("Eight");
        linkedList.addLast("Nine");
        linkedList.addLast("Ten");

        System.out.println(linkedList);

        System.out.println("First: " + linkedList.peekFirst());
        System.out.println("Last: " + linkedList.peekLast());

        System.out.println(linkedList.pollFirst());

        System.out.println(linkedList);

        System.out.println(linkedList.pollLast());

        System.out.println(linkedList);

        System.out.println(linkedList.contains("Four"));
        System.out.println(linkedList.contains("Nine"));
        System.out.println(linkedList.contains("Ten"));

        System.out.println(linkedList.size());

        linkedList.clear();

        System.out.println(linkedList.size());

        System.out.println(linkedList);



    }
}