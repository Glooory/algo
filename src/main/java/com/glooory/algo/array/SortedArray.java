package com.glooory.algo.array;

public class SortedArray {
    private int[] data;
    private int size = 0;

    public SortedArray() {
        this.data = new int[10];
    }

    public SortedArray(int size) {
        this.data = new int[size];
    }

    // O(n)
    public void add(int num) {
        ensureCapacity();

        // insert first
        data[size] = num;
        size++;

        // sort
        for (int i = size - 1; i > 0; i--) {
            if (data[i] < data[i - 1]) {
                int temp = data[i - 1];
                data[i - 1] = data[i];
                data[i] = temp;
            } else {
                break;
            }
        }
    }

    // O(n)
    public boolean remove(int value) {
        if (size == 0) {
            return false;
        }

        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                found = true;
            }
            if (found && i < size - 1) {
                data[i] = data[i + 1];
            }
        }
        if (found) {
            size--;
        }

        return found;
    }

    public int get(int index) {
        checkIndex(index);
        return data[index];
    }

    public int size() {
        return this.size;
    }

    /**
     * https://leetcode.com/problems/merge-sorted-array/
     *
     * Merge Sorted Array
     * @param firstArray
     * @param m
     * @param secondArray
     * @param n
     * @return
     */
    public static void merge(int[] firstArray, int m, int[] secondArray, int n) {
        for (int i = n - 1; i >= 0; i--) {
            firstArray[m++] = secondArray[i];
            for (int j = m - 1; j > 0; j--) {
                if (firstArray[j] < firstArray[j - 1]) {
                    int temp = firstArray[j - 1];
                    firstArray[j - 1] = firstArray[j];
                    firstArray[j] = temp;
                } else {
                    break;
                }
            }
        }
    }

    private void ensureCapacity() {
        if (size >= data.length - 1) {
            grow();
        }
    }

    private void grow() {
        int[] newData = new int[data.length * 2];
        for (int i = 0; i < data.length; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size - 1) {
            throw new IllegalArgumentException("Illegal argument index: " + index);
        }
    }
}
