package org.example.sandbox.queues;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

public class ArrayListQueue<T> implements Queue<T> {

    private List<T> queue;

    public ArrayListQueue() {
        queue = new ArrayList<>();
    }

    @Override
    public boolean offer(T t) {
        return this.queue.add(t);
    }

    @Override
    public T poll() {

        T t = null;
        try {
            t = this.queue.removeFirst();
        } catch(NoSuchElementException e) {
            e.printStackTrace();
            throw new EmptyQueueException("Queue is empty");
        }
        return t;
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
        sb.append("<-- ").append(queue);
        sb.append(" <--");
        return sb.toString();
    }
}