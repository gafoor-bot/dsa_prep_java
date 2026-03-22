import java.util.HashSet;
// Link: https://neetcode.io/problems/duplicate-integer/question?list=neetcode150
class Solution {
    public boolean hasDuplicate(int[] nums) {
        // Create a HashSet to store elements we have seen so far
        HashSet<Integer> set = new HashSet<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the element is already in the set, we found a duplicate
            if (set.contains(nums[i])) {
                return true;
            } else {
                // Otherwise, add the element to the set
                set.add(nums[i]);
            }
        }

        // If no duplicates are found, return false
        return false;
    }
}

/*
Time Complexity:
O(n) - We iterate through the array once, and each HashSet operation
(add, contains) takes O(1) on average.

Space Complexity:
O(n) - In the worst case, we store all elements in the HashSet.
*/