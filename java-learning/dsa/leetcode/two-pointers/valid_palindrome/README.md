# 125. Valid Palindrome

[LeetCode Link](https://leetcode.com/problems/valid-palindrome/)

## The Core Idea
The goal is to check if a string reads the same backward as forward, ignoring case, spaces, and punctuation.

Instead of doing something expensive like stripping out characters with regex or copying the string to reverse it, I used an in-place two-pointer approach to keep memory usage flat.

## My Approach
1. **Pointers on both ends:** Place a `left` pointer at the start and a `right` pointer at the end of the string.
2. **Skip the noise:** Move the pointers toward the center. If a pointer lands on a symbol or a space, skip it using `Character.isLetterOrDigit()`.
3. **Compare on the fly:** Convert both characters to lowercase and check if they match. If they don't, break early and return `false`.
4. If the pointers meet without a mismatch, it's a valid palindrome.

## Complexity
* **Time:** $O(n)$ — In the worst-case scenario (a valid palindrome), we look at every character in the string exactly once.
* **Space:** $O(1)$ — This is the main win. Because we are manipulating pointers directly on the original string, we aren't allocating any extra memory for string copies or arrays.