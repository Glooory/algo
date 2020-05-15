package com.glooory.algo.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.glooory.algo.recursion.Factorial.*;

class FactorialTest {

    @Test
    void factorialWithCahceTest() {
        assertThrows(IllegalArgumentException.class, () -> factorial(0));
        assertEquals(1, factorial(1));
        assertEquals(2, factorial(2));
        assertEquals(6, factorial(3));
        assertEquals(24, factorial(4));
        assertEquals(120, factorial(5));
        assertEquals(720, factorial(6));
        assertEquals(5040, factorial(7));
        assertEquals(40320, factorial(8));
        assertEquals(362880, factorial(9));
        assertEquals(3628800, factorial(10));
        assertEquals(39916800, factorial(11));
        assertEquals(479001600, factorial(12));
    }

}