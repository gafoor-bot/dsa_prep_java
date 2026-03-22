import java.util.HashMap;
// Link: https://neetcode.io/problems/two-integer-sum/question
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // HashMap to store (number -> index)
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];

            // Check if the complement already exists in the map
            if (map.containsKey(complement)) {
                // If found, return the indices
                return new int[] { map.get(complement), i };
            }

            // Otherwise, store the current number with its index
            map.put(nums[i], i);
        }

        // If no solution is found (though problem guarantees one), return empty array
        return new int[] {};
    }
}

/*
Time Complexity:
O(n) - We traverse the array once, and each HashMap operation
(put, containsKey, get) takes O(1) on average.

Space Complexity:
O(n) - In the worst case, we store all elements in the HashMap.
*/