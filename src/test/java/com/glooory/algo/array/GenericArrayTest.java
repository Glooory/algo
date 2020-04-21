package com.glooory.algo.array;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericArrayTest {

    @Test
    void size() {
        GenericArray<String> a = new GenericArray<String>(2);
        assertEquals(0, a.size());
    }

    @Test
    void isEmpty() {
        GenericArray<String> a = new GenericArray<String>(2);
        assertTrue(a.isEmpty());
        a.add("d");
        assertFalse(a.isEmpty());
    }

    @Test
    void contains() {
        GenericArray<String> a = new GenericArray<String>(2);
        assertFalse(a.contains("d"));
        a.add("d");
        assertTrue(a.contains("d"));
    }

    @Test
    void add() {
        GenericArray<String> a = new GenericArray<String>(2);
        a.add("d");
        assertFalse(a.isEmpty());
    }

    @Test
    void addWithIndex() {
        GenericArray<String> a = new GenericArray<String>(2);
        a.add(0, "d");
        a.add(1, "D");
        a.add(2, "E");
        assertEquals(3, a.size());
        assertEquals("d", a.get(0));
        assertEquals("D", a.get(1));
        assertEquals("E", a.get(2));
    }

    @Test
    void removeByIndex() {
        GenericArray<String> a = new GenericArray<String>(2);
        a.add("D");
        a.add("F");
        assertEquals("D", a.get(0));
        a.remove(0);
        assertEquals(1, a.size());
        assertEquals(-1, a.indexOf("D"));
    }

    @Test
    void removeByItem() {
        GenericArray<String> a = new GenericArray<String>(2);
        assertFalse(a.remove("f"));
        a.add("D");
        a.add("F");
        assertEquals("D", a.get(0));
        a.remove("D");
        assertEquals(1, a.size());
        assertEquals(-1, a.indexOf("D"));
    }

    @Test
    void get() {
        GenericArray<String> a = new GenericArray<String>(2);
        a.add("D");
        assertEquals("D", a.get(0));
    }

    @Test
    void set() {
        GenericArray<String> a = new GenericArray<String>(2);
        a.add("D");
        assertEquals("D", a.get(0));
        a.set(0, "F");
        assertEquals("F", a.get(0));
    }

    @Test
    void indexOf() {
        GenericArray<String> a = new GenericArray<String>(2);
        a.add("D");
        assertEquals(0, a.indexOf("D"));
        assertEquals(-1, a.indexOf("FD"));
    }
}