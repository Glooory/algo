package com.glooory.algo.sort;

public class BubbleSort {

    public static int[] sort(int[] nums) {
        if (nums == null) {
            return new int[0];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }

        return nums;
    }

    public static void printAll(int[] nums) {
        if (nums == null) {
            System.out.println("null");
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("[");
            for (int i = 0; i < nums.length; i++) {
                stringBuilder.append(nums[i]);
                if (i != nums.length - 1) {
                    stringBuilder.append(", ");
                }
            }
            stringBuilder.append("]");
            System.out.println(stringBuilder.toString());
        }
    }
}
