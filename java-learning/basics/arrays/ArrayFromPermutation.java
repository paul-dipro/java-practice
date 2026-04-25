import java.util.*;

class Solution {
    public int[] buildArray(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] + (nums[nums[i]] % n) * n;
        }

        for (int i = 0; i < n; i++) {
            nums[i] = nums[i] / n;
        }

        return nums;
    }
}

public class ArrayFromPermutation {
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums = {0, 2, 1, 5, 3, 4};

        int[] result = sol.buildArray(nums);

        System.out.println(Arrays.toString(result));
    }
}