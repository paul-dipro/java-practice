package leetcode.strings.valid_palindrome;

/**
 * LeetCode 125: Valid Palindrome
 *
 * Time Complexity: O(n) - Single pass where n is the length of the string.
 * Space Complexity: O(1) - Constant space used by two pointers; no extra strings created.
 */


public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.isEmpty()) {
            return true;
        }

        int left = 0;
        int right = s.length() - 1;

        while (left < right) {
            char cLeft = s.charAt(left);
            char cRight = s.charAt(right);

            if (!Character.isLetterOrDigit(cLeft)) {
                left++;
                continue;
            }

            if (!Character.isLetterOrDigit(cRight)) {
                right--;
                continue;
            }

            if (Character.toLowerCase(cLeft) != Character.toLowerCase(cRight)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}