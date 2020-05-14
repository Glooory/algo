package com.glooory.algo.recursion;

import java.util.HashMap;
import java.util.Map;

public class Fabonacci {
    private static Map<Integer, Integer> cache;

    public static int fabonacci(int n) {
        validateParam(n);
        cache = new HashMap<>();
        int result = fabonacciWithCache(n);
        cache = null;
        return result;
    }

    private static int fabonacciWithCache(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        int result = fabonacciWithCache(n - 1) + fabonacciWithCache(n - 2);
        cache.put(n, result);
        return result;
    }

    public static int fabonacciWithoutCache(int n) {
        validateParam(n);
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        return fabonacciWithoutCache(n - 1) + fabonacciWithoutCache(n - 2);
    }

    private static void validateParam(int param) {
        if (param < 1) {
            throw new IllegalArgumentException("Parameter n must be positive, but got " + param);
        }
    }
}
