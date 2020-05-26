package com.glooory.algo.sort;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BubbleSortTest {

    @Test
    void sort() {
        BubbleSort.printAll(BubbleSort.sort(new int[]{2, 7, 88, 311, 43, 5, 2373, 0, -2, 2}));
    }
}