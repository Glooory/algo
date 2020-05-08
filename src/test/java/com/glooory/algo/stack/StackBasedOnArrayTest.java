package com.glooory.algo.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackBasedOnArrayTest {
    private StackBasedOnArray stack;
    private int NUM_1 = 1;
    private int NUM_2 = 2;
    private int NUM_3 = 3;
    private int NUM_4 = 4;

    @BeforeEach
    void setup() {
        stack = new StackBasedOnArray(2);
    }

    @AfterEach
    void cleanup() {
        stack = null;
    }

    @Test
    void push() {
        assertEquals(1, stack.push(NUM_1));
        assertEquals(2, stack.push(NUM_2));
        assertEquals(3, stack.push(NUM_3));
    }

    @Test
    void pop() {
        stack.push(NUM_1);
        stack.push(NUM_2);
        stack.push(NUM_3);
        assertEquals(NUM_3, stack.pop());
        assertEquals(NUM_2, stack.pop());
        assertEquals(NUM_1, stack.pop());
        assertEquals(Integer.MIN_VALUE, stack.pop());
    }

    @Test
    void size() {
        assertEquals(0, stack.size());
        assertEquals(1, stack.push(NUM_1));
        stack.pop();
        assertEquals(0, stack.size());
        stack.push(NUM_1);
        stack.push(NUM_2);
        stack.push(NUM_3);
        assertEquals(3, stack.size());
    }
}