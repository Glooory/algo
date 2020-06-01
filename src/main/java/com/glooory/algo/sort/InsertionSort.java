package com.glooory.algo.sort;

public class InsertionSort {

    public static int[] sort(int[] nums) {
        if (nums == null) {
            return nums;
        }

        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (value < nums[j]) {
                    nums[j + 1] = nums[j];
                } else {
                    break;
                }
            }
            nums[j + 1] = value;
        }

        return nums;
    }

}
