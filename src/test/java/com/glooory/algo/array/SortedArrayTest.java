package com.glooory.algo.array;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortedArrayTest {
    SortedArray arr;

    @BeforeEach
    void setup() {
        arr = new SortedArray(2);
    }

    @AfterEach
    void cleanup() {
        arr = null;
    }

    @Test
    void add() {
        assertEquals(0, arr.size());
        arr.add(3);
        assertEquals(1, arr.size());
        assertEquals(3, arr.get(0));
        arr.add(1);
        assertEquals(2, arr.size());
        assertEquals(1, arr.get(0));
        assertEquals(3, arr.get(1));

        arr = new SortedArray(1);
        arr.add(3);
        assertEquals(1, arr.size());
        assertEquals(3, arr.get(0));
        arr.add(5);
        assertEquals(2, arr.size());
        assertEquals(3, arr.get(0));
        assertEquals(5, arr.get(1));

        arr.add(12);
        assertEquals(3, arr.size());
        assertEquals(12, arr.get(2));
    }

    @Test
    void remove() {
        assertEquals(0, arr.size());
        arr.add(3);
        assertEquals(1, arr.size());
        assertFalse(arr.remove(1));
        assertTrue(arr.remove(3));
        assertEquals(0, arr.size());
        arr.add(344);
        arr.add(23);
        arr.add(3);
        assertTrue(arr.remove(23));
        assertEquals(3, arr.get(0));
        assertEquals(2, arr.size());
        assertTrue(arr.remove(3));
        assertEquals(1, arr.size());
    }

    @Test
    void get() {
        arr.add(45);
        arr.add(2);
        assertEquals(2, arr.get(0));
        assertEquals(45, arr.get(1));
    }
}