package com.glooory.algo.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Subsets {

    /**
     * 78. Subsets https://leetcode.com/problems/subsets/
     *
     * Given a set of distinct integers, nums, return all possible subsets (the power set).
     *
     * Note: The solution set must not contain duplicate subsets.
     *
     * Example:
     *
     * Input: nums = [1,2,3]
     * Output:
     * [
     *   [3],
     *   [1],
     *   [2],
     *   [1,2,3],
     *   [1,3],
     *   [2,3],
     *   [1,2],
     *   []
     * ]
     *
     * @param nums
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        Arrays.sort(nums);
        backtrack(nums, new ArrayList<>(), 0, result);

        return result;
    }

    private static void backtrack(int[] nums, List<Integer> tempList, int start, List<List<Integer>> result) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backtrack(nums, tempList, i + 1, result);
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * 90. Subsets II https://leetcode.com/problems/subsets-ii/
     *
     * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
     *
     * Note: The solution set must not contain duplicate subsets.
     *
     * Example:
     *
     * Input: [1,2,2]
     * Output:
     * [
     *   [2],
     *   [1],
     *   [1,2,2],
     *   [2,2],
     *   [1,2],
     *   []
     * ]
     *
     * @param nums
     * @return
     */
    public static List<List<Integer>> subsetsWithDuplicates(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backtrackWithDuplicates(nums, new ArrayList<>(), used, 0, result);

        return result;
    }

    private static void backtrackWithDuplicates(int[] nums, List<Integer> tempList, boolean[] used, int start, List<List<Integer>> result) {
        result.add(new ArrayList<>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            tempList.add(nums[i]);
            backtrackWithDuplicates(nums, tempList, used, i + 1, result);
            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
