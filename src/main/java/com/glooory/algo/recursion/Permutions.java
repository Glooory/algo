package com.glooory.algo.recursion;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
}
