package leetcode.strings.implement_strstr;

/**
 * LeetCode 28: Find the Index of the First Occurrence in a String (strStr)
 *
 * Time Complexity: O((N - M) * M) where N is haystack length and M is needle length.
 * Space Complexity: O(1) - Constant auxiliary space.
 */


public class Solution {
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || needle.length() > haystack.length()) {
            return -1;
        }

        // only iterate up to the point where the remaining length is at least the needle's length
        for (int i = 0; i <= haystack.length() - needle.length(); i++) {
            boolean found = true;

            for (int j = 0; j < needle.length(); j++) {
                if (haystack.charAt(i + j) != needle.charAt(j)) {
                    found = false;
                    break;
                }
            }

            if (found) {
                return i;
            }
        }
        return -1;
    }
}