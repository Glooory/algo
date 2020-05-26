package com.glooory.algo.sort;

public class BubbleSort {

    public static int[] sort(int[] nums) {
        if (nums == null) {
            return new int[0];
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    int temp = nums[i];
                    nums[i] = nums[j];
                    nums[j] = temp;
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
