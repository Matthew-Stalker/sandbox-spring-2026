package org.example.sandbox.queues;

import java.util.LinkedList;
import java.util.List;

public class LinkedListQueue<T> implements Queue<T> {

    private List<T> queue;

    public LinkedListQueue() {
        this.queue = new LinkedList<>();
    }

    @Override
    public boolean offer(T t) {

        this.queue.addLast(t);

        T query = this.queue.getLast();

        return (query == t);
    }

    @Override
    public T poll() {
        return this.queue.removeFirst();
    }

    @Override
    public T peek() {
        return this.queue.getFirst();
    }

    @Override
    public int size() {
        return this.queue.size();
    }

    @Override
    public boolean isEmpty() {
        return this.queue.isEmpty();
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("<--").append(queue);
        sb.append(" ---");
        return sb.toString();
    }
}
