package com.glooory.algo.queue;

public class QueueBasedOnArray {
    private int[] data = new int[5];
    private int size = 0;

    public QueueBasedOnArray(int initialSize) {
        if (initialSize < 1) {
            throw new IllegalArgumentException("" + initialSize + " must be positive integer");
        }
        this.data = new int[initialSize];
    }

    public boolean add(int element) {
        ensureCapacity();
        this.data[size] = element;
        size++;
        return true;
    }

    public int poll() {
        if (size < 1) {
            return Integer.MIN_VALUE;
        }
        int element = data[0];
        for (int i = 0; (i < size - 1) && (i < data.length - 1); i++) {
            data[i] = data[i + 1];
        }
        size--;
        return element;
    }

    public void clear() {
        while (size > 0) {
            poll();
        }
    }

    private void ensureCapacity() {
        if (size == data.length) {
            int[] newData = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
    }
}
