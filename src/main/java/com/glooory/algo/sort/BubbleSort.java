package com.glooory.algo.sort;

public class BubbleSort {

    public static int[] sort(int[] nums) {
        if (nums == null) {
            return new int[0];
        }

        for (int i = 0; i < nums.length; i++) {
            // 提前退出冒泡循环的标志
            boolean dataTransferred = false;
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                    dataTransferred = true; // 表示有数据交换
                }
            }
            if (!dataTransferred) {
                break; // 没有数据交换，提前退出
            }
        }

        return nums;
    }

}
