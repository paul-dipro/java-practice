package leetcode.arrays.two_sum;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

    private final Solution solution = new Solution();

    @Test
    public void testTwoSum_StandardCase() {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = solution.twoSum(nums, target);
        assertArrayEquals(new int[] {0, 1}, result);
    }

    @Test
    public void testTwoSum_UnsortedElements() {
        int[] nums = {3, 2, 4};
        int target = 6;
        int[] result = solution.twoSum(nums, target);
        assertArrayEquals(new int[] {1, 2}, result);
    }

    @Test
    public void testTwoSum_DuplicateElements() {
        int[] nums = {3, 3};
        int target = 6;
        int[] result = solution.twoSum(nums, target);
        assertArrayEquals(new int[] {0, 1}, result);
    }
}