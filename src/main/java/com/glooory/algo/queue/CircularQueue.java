package com.glooory.algo.queue;

public class CircularQueue {
    private int[] data;
    private int head = 0;
    private int tail = 0;

    public CircularQueue(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("Capacity must be positive! Found " + capacity);
        }
        this.data = new int[capacity + 1];
    }

    public CircularQueue() {
        this.data = new int[6];
    }

    public boolean enqueue(int data) {
        int size = this.data.length;
        if ((tail + 1) % size == head) {
            return false;
        }

        this.data[tail] = data;
        tail = (tail + 1) % size;
        return true;
    }

    public int dequeue() {
        if (head == tail) {
            return Integer.MIN_VALUE;
        }

        int data = this.data[head];
        head = (head + 1) % this.data.length;
        return data;
    }

    public void clear() {
        while (dequeue() != Integer.MIN_VALUE) {
            dequeue();
        }
    }
}
