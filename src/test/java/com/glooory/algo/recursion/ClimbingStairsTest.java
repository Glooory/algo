package com.glooory.algo.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.glooory.algo.recursion.ClimbingStairs.*;

class ClimbingStairsTest {

    @Test
    void climbStairsTest() {
        assertThrows(IllegalArgumentException.class, () -> climbStairs(0));
        assertEquals(1, climbStairs(1));
        assertEquals(2, climbStairs(2));
        assertEquals(3, climbStairs(3));
        assertEquals(5, climbStairs(4));
        assertEquals(8, climbStairs(5));
        assertEquals(13, climbStairs(6));
        assertEquals(4181, climbStairs(18));
    }
}