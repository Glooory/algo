package com.glooory.algo.stack;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackBasedOnLinkedListTest {
    private StackBasedOnLinkedList stack;
    private int NUM_1 = 1;
    private int NUM_2 = 2;
    private int NUM_3 = 3;
    private int NUM_4 = 4;

    @BeforeEach
    void setup() {
        stack = new StackBasedOnLinkedList();
    }

    @AfterEach
    void clearup() {
        stack = null;
    }

    @Test
    void push() {
        stack.push(NUM_1);
        assertEquals(NUM_1, stack.pop());
        stack.push(NUM_1);
        stack.push(NUM_2);
        stack.push(NUM_3);
        assertEquals(NUM_3, stack.pop());
        assertEquals(NUM_2, stack.pop());
        assertEquals(NUM_1, stack.pop());
        assertEquals(Integer.MIN_VALUE, stack.pop());
    }

    @Test
    void pop() {
        assertEquals(Integer.MIN_VALUE, stack.pop());
    }
}