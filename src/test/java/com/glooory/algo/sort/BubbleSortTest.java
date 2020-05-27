package com.glooory.algo.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {
    private int[] arr = new int[]{2, 7, 88, 311, 43, 5, 2373, 0, -2, 2, 34, 634563, 6436, 523, -322, 32, -34, 43, 762};

    @Test
    void sort() {
        BubbleSort.printAll(BubbleSort.sort(arr));
    }
}