package com.glooory.algo.recursion;

public class Factorial {
    public static int factorial(int n) {
        if (n < 1) {
            throw new IllegalArgumentException("Parameter n must be positive, but got " + n);
        }

        if (n == 1) {
            return 1;
        }

        return n * factorial(n - 1);
    }
}
