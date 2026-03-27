package org.example.sandbox.queues;

public class EmptyQueueException extends RuntimeException {

    public EmptyQueueException() {
    }

    public EmptyQueueException(String message) {
        super(message);
    }

    public EmptyQueueException(String message, Throwable cause) {
        super(message, cause);
    }

    public EmptyQueueException(Throwable cause) {
        super(cause);
    }
}