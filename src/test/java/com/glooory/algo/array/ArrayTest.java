package com.glooory.algo.array;

import static org.junit.jupiter.api.Assertions.*;

class ArrayTest {

    @org.junit.jupiter.api.Test
    void find() {
        Array a = new Array(5);
        assertEquals(-1, a.find(0));
        assertEquals(-1, a.find(-1));
        assertEquals(-1, a.find(1000));
        a.insert(0, 1);
        assertEquals(1, a.find(0));
    }

    @org.junit.jupiter.api.Test
    void insert() {
        Array a = new Array(2);
        a.insert(0, 1);
        a.insert(1, 2);
        assertEquals(1, a.find(0));
        assertEquals(2, a.find(1));
        assertEquals(2, a.size());
        assertFalse(a.insert(3, 23));
        a.insert(2, 3);
        assertEquals(3, a.find(2));
        assertEquals(-1, a.find(5));
        assertEquals(3, a.size());
    }

    @org.junit.jupiter.api.Test
    void delete() {
        Array a = new Array(2);
        assertFalse(a.delete(0));
        a.insert(0, 1);
        assertEquals(1, a.find(0));
        a.delete(0);
        assertEquals(-1, a.find(0));
        assertEquals(0, a.size());
    }

    @org.junit.jupiter.api.Test
    void size() {
        Array a = new Array(2);
        assertEquals(0, a.size());
        a.insert(0, 1);
        assertEquals(1, a.size());
        assertTrue(a.insert(1, 2));
        assertTrue(a.insert(2, 3));
        assertEquals(3, a.size());
    }
}