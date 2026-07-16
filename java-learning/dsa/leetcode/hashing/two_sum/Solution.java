package leetcode.arrays.two_sum;

import java.util.HashMap;

/**
 * LeetCode 1: Two Sum
 *
 * Time Complexity: O(N) - Single pass through the array.
 * Space Complexity: O(N) - To store up to N elements in the HashMap.
 */


public class Solution {
    public int[] twoSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return new int[] {};
        }

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int currentNum = nums[i];
            int complement = target - currentNum;

            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }

            map.put(currentNum, i);
        }
        return new int[] {};
    }
}