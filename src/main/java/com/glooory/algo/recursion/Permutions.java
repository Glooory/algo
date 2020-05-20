package com.glooory.algo.recursion;

import java.util.*;

public class Permutions {

    /**
     *
     * @param nums array of distinct integers
     */
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, new ArrayList<Integer>(), new HashSet<Integer>(), result);

        return result;
    }

    private static void backtrack(int[] nums, List<Integer> tempList, Set<Integer> tempSet, List<List<Integer>> result) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (tempSet.contains(nums[i])) {
                continue;
            }

            tempSet.add(nums[i]);
            tempList.add(nums[i]);

            backtrack(nums, tempList, tempSet, result);

            tempSet.remove(tempList.get(tempList.size() - 1));
            tempList.remove(tempList.size() - 1);
        }
    }

    /**
     * 47. Permutations II https://leetcode.com/problems/permutations-ii/
     * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
     *
     * Example:
     *
     * Input: [1,1,2]
     * Output:
     * [
     *   [1,1,2],
     *   [1,2,1],
     *   [2,1,1]
     * ]
     * @param nums
     * @return
     */
    public static List<List<Integer>> permuteDuplicates(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 1) {
            return result;
        }

        List<Integer> tempList = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        Arrays.sort(nums);

        backtrackDuplicates(nums, tempList, used, result);

        return result;
    }

    private static void backtrackDuplicates(int[] nums, List<Integer> tempList, boolean[] used, List<List<Integer>> result) {
        if (nums.length == tempList.size()) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (used[i]) {
                continue;
            }
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            used[i] = true;
            tempList.add(nums[i]);

            backtrackDuplicates(nums, tempList, used, result);

            used[i] = false;
            tempList.remove(tempList.size() - 1);
        }
    }
}
