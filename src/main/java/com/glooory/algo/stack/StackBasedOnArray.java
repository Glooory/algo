package com.glooory.algo.stack;

public class StackBasedOnArray {
    private int size = 0;
    private int[] data = new int[10];

    public StackBasedOnArray(int initialSize) {
        data = new int[initialSize];
    }

    public int push(int num) {
        ensureCapacity();
        data[size] = num;
        size++;
        return size;
    }

    public int pop() {
        if (size < 1) {
            return Integer.MIN_VALUE;
        }
        int value = data[size - 1];
        size--;
        return value;
    }

    public int size() {
        return size;
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
