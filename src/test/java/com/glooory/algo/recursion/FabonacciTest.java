package com.glooory.algo.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.glooory.algo.recursion.Fabonacci.*;

class FabonacciTest {

    @Test
    void fabonacciTest() {
        assertThrows(IllegalArgumentException.class, () -> fabonacci(0));
        assertEquals(0, fabonacci(1));
        assertEquals(1, fabonacci(2));
        assertEquals(1, fabonacci(3));
        assertEquals(2, fabonacci(4));
        assertEquals(3, fabonacci(5));
        assertEquals(5, fabonacci(6));
        assertEquals(8, fabonacci(7));
        assertEquals(317811, fabonacci(29));
        assertEquals(701408733, fabonacci(45));
        assertEquals(1836311903, fabonacci(47));

    }

    @Test
    void fabonacciWithoutCacheTest() {
        assertThrows(IllegalArgumentException.class, () -> fabonacciWithoutCache(0));
        assertEquals(0, fabonacciWithoutCache(1));
        assertEquals(1, fabonacciWithoutCache(2));
        assertEquals(1, fabonacciWithoutCache(3));
        assertEquals(2, fabonacciWithoutCache(4));
        assertEquals(3, fabonacciWithoutCache(5));
        assertEquals(5, fabonacciWithoutCache(6));
        assertEquals(8, fabonacciWithoutCache(7));
        assertEquals(317811, fabonacciWithoutCache(29));
        assertEquals(701408733, fabonacciWithoutCache(45));
        assertEquals(1836311903, fabonacciWithoutCache(47));
    }
}