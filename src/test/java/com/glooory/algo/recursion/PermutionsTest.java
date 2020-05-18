package com.glooory.algo.recursion;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static com.glooory.algo.recursion.Permutions.*;

class PermutionsTest {

    @Test
    void permuteTest() {
        assertEquals(6, permute(new int[]{ 1, 2, 3}).size());
    }
}