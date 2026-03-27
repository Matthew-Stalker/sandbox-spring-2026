package org.example.sandbox.queues;

public class QueueDriver {

    public static void main(String[] args) {

        Queue<String> queue = new LinkedListQueue<>();

        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");

        System.out.println(queue);

        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());

        System.out.println(queue);

        System.out.println(queue.isEmpty());
        System.out.println(queue.size());

        try {
            queue.poll();
            queue.poll();
            queue.poll();
            queue.poll();
            queue.poll();
            queue.poll();
            queue.poll();
            queue.poll();
        } catch (Exception e) {
            System.out.println("Queue is empty");
        }

        System.out.println(queue.isEmpty());

    }
}