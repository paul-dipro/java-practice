# 28. Find the Index of the First Occurrence in a String

### [LeetCode Link](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)

## The Core Idea
My goal is to locate the first index where a substring (`needle`) appears inside a main string (`haystack`).

Instead of using heavy built-in methods like Java's `.substring()`—which creates and allocates entirely new string objects on the heap—I decided to slide a manual "window" of the needle's length across the haystack. This allows me to compare characters in-place using simple pointer offsets, keeping memory usage flat.

## My Approach
1. **Define the Search Boundary:** I limit my loop to run only up to `haystack.length() - needle.length()`. There is no point in checking past this boundary because there are not enough characters left in the haystack to match the needle anyway.
2. **Character Comparison:** For each starting position `i` in the haystack, I use a nested pointer `j` to match the characters of the needle against the haystack at index `i + j`.
3. **Early Pruning:** If I encounter a mismatch at any index, I break out of the inner loop immediately to save CPU cycles.
4. **Result:** If the inner loop finishes without breaking, I successfully matched the entire needle, so I return the current starting index `i`. If I exhaust all starting positions without a match, I return `-1`.

## Complexity
* **Time:** $O((N - M) \times M)$ where $N$ is the length of `haystack` and $M$ is the length of `needle`. In the worst-case scenario (like checking "aaaaab" against "aab"), I have to backtrack and check characters multiple times.
* **Space:** $O(1)$ auxiliary space. I perform the entire search in-place using existing string pointers, meaning zero extra memory is allocated on the JVM heap.