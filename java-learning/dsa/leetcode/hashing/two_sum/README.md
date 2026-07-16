# 1. Two Sum

### [LeetCode Link](https://leetcode.com/problems/two-sum/)

## The Core Idea
The brute-force way to solve this is to check every single pair of numbers in the array, which takes $O(N^2)$ time.

To optimize this to linear time, I used a **HashMap** to remember the numbers I have already seen and their corresponding array indices. For each number, instead of searching forward for its match, I calculate its "complement" (the exact value needed to reach the target) and immediately look backward in the map to see if I have already scanned it.

## My Approach
1. **Initialize the Map:** I create a `HashMap<Integer, Integer>` where the key is the number from the array and the value is its index.
2. **Iterate & Calculate:** As I iterate through the array, I calculate the `complement = target - nums[i]`.
3. **Instant Lookup:** I check if the map already contains this complement.
    * If it does, I have found the pair! I return the index of the complement from the map and my current index `i`.
    * If it does not, I store my current number and its index in the map and continue moving forward.
4. **Fallback:** If no pair is found, I return an empty array.

## Complexity
* **Time:** $O(N)$ — I only traverse the array once. Each lookup and insertion in the HashMap runs in $O(1)$ average time.
* **Space:** $O(N)$ — In the worst-case scenario (e.g., the matching pair is at the very end of the array), I store up to $N$ elements in the map.