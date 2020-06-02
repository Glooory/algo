package com.glooory.algo.sort;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {
    private int[] arr;

    @BeforeEach
    void setup() {
        arr = new int[]{2, 7, 88, 311, 43, 5, 2373, 0, -2, 2, 34, 634563, 6436, 523, -322, 32, -34, 43, 762};
    }

    @AfterEach
    void cleanup() {
        arr = null;
    }

    @Test
    void bubbleSort() {
        PrintArray.print(BubbleSort.sort(arr));
    }

    @Test
    void insertionSort() {
        PrintArray.print(InsertionSort.sort(arr));
    }

    @Test
    void selectionSort() {
        PrintArray.print(SelectionSort.sort(arr));
    }
}