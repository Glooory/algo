package com.glooory.algo.sort;

public class PrintArray {

    public static void print(int[] nums) {
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
