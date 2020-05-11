package com.glooory.algo.queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;

class QueueBasedOnArrayTest {
    private QueueBasedOnArray queue = null;
    private final int NUM_1 = 1;
    private final int NUM_2 = 2;
    private final int NUM_3 = 3;
    private final int NUM_4 = 4;

    @BeforeEach
    void setup() {
        queue = new QueueBasedOnArray(2);
    }

    @AfterEach
    void clearUp() {
        queue = null;
    }

    @Test
    void testInitialState() {
        assertEquals(Integer.MIN_VALUE, queue.poll());
        assertThrows(IllegalArgumentException.class, () -> new QueueBasedOnArray(0));
    }

    @Test
    void addAndPoll() {
        queue.add(NUM_1);
        queue.add(NUM_2);
        queue.add(NUM_3);
        queue.add(NUM_4);
        assertEquals(NUM_1, queue.poll());
        assertEquals(NUM_2, queue.poll());
        assertEquals(NUM_3, queue.poll());
        assertEquals(NUM_4, queue.poll());
        assertEquals(Integer.MIN_VALUE, queue.poll());
        queue = new QueueBasedOnArray(1);
        queue.add(NUM_1);
        assertEquals(NUM_1, queue.poll());
        queue.add(NUM_2);
        queue.add(NUM_3);
        assertEquals(NUM_2, queue.poll());
        assertEquals(NUM_3, queue.poll());
        queue.add(NUM_4);
        assertEquals(NUM_4, queue.poll());
        assertEquals(Integer.MIN_VALUE, queue.poll());
    }

    @Test
    void clear() {
        queue.add(NUM_1);
        queue.add(NUM_2);
        queue.add(NUM_3);
        queue.clear();
        assertEquals(Integer.MIN_VALUE, queue.poll());
    }
}