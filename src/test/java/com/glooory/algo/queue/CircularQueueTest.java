package com.glooory.algo.queue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircularQueueTest {
    private CircularQueue queue;
    private final int NUM_1 = 1;
    private final int NUM_2 = 2;
    private final int NUM_3 = 3;
    private final int NUM_4 = 4;

    @BeforeEach
    void setup() {
        queue = new CircularQueue();
    }

    @AfterEach
    void clearUp() {
        queue = null;
    }

    @Test
    void testInitialState() {
        assertEquals(Integer.MIN_VALUE, queue.dequeue());
        assertThrows(IllegalArgumentException.class, () -> {
            queue = new CircularQueue(0);
        });
    }

    @Test
    void enqueueAndDequeue() {
        assertTrue(queue.enqueue(NUM_1));
        assertTrue(queue.enqueue(NUM_2));
        assertTrue(queue.enqueue(NUM_3));
        assertEquals(NUM_1, queue.dequeue());
        assertEquals(NUM_2, queue.dequeue());
        assertEquals(NUM_3, queue.dequeue());
        assertEquals(Integer.MIN_VALUE, queue.dequeue());

        queue = new CircularQueue(2);
        assertTrue(queue.enqueue(NUM_1));
        assertTrue(queue.enqueue(NUM_2));
        assertFalse(queue.enqueue(NUM_3));
        assertEquals(NUM_1, queue.dequeue());
        assertEquals(NUM_2, queue.dequeue());
        assertEquals(Integer.MIN_VALUE, queue.dequeue());
    }

    @Test
    void clear() {
        queue.enqueue(NUM_1);
        queue.enqueue(NUM_2);
        queue.enqueue(NUM_3);
        queue.enqueue(NUM_4);
        assertEquals(NUM_1, queue.dequeue());
        queue.clear();
        assertEquals(Integer.MIN_VALUE, queue.dequeue());
    }
}