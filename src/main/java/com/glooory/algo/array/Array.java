package com.glooory.algo.array;

public class Array {
    private int[] data;
    private int size;

    public Array(int size) {
        data = new int[size];
        this.size = 0;
    }

    public int find(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        return data[index];
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > size) {
            return false;
        }
        if (size == data.length) {
            int[] newData = new int[data.length * 2];
            for (int i = 0; i < data.length; i++) {
                newData[i] = data[i];
            }
            data = newData;
        }
        for (int j = size - 1; j > index; j--) {
            data[j] = data[j - 1];
        }
        data[index] = value;
        size++;
        return true;
    }

    public boolean delete(int index) {
        if (index < 0 || index >= size) {
            return false;
        }
        for (int i = index; i < size; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return true;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "[]";
        }
        String s = "[";
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                s += data[i];
            } else {
                s = s + data[i] + ",";
            }
        }
        s += "]";
        return s;
    }
}
