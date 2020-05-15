package com.glooory.algo.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 *
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {

    public static int climbStairs(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Parameter n must be positive, but got " + n);
        }

        Map<Integer, Integer> cache = new HashMap<>();
        return climb(n, cache);
    }

    private static int climb(int n, Map<Integer, Integer> cache) {
        if (n == 1) {
            return 1;
        }

        if (n == 2) {
            return 2;
        }

        if (cache.containsKey(n)) {
            return cache.get(n);
        }

        int result = climb(n - 1, cache) + climb(n - 2, cache);
        cache.put(n, result);
        return result;
    }

}
