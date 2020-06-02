package com.glooory.algo.sort;

public class SelectionSort {

    public static int[] sort(int[] nums) {
        if (nums == null) {
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = temp;
        }

        return nums;
    }

}
