// Link: https://neetcode.io/problems/longest-consecutive-sequence/question
import java.util.HashSet;

class Solution {
    public int longestConsecutive(int[] nums) {
        // Edge case: if array is empty, return 0
        if (nums.length == 0) return 0;

        // Use a HashSet for O(1) lookups
        HashSet<Integer> set = new HashSet<>();

        // Add all elements to the set
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }

        int longest = 1; // Stores the maximum length of consecutive sequence
        int count = 1;   // Tracks current sequence length

        // Iterate through each unique element
        for (int e : set) {

            // Only start counting if 'e' is the beginning of a sequence
            // (i.e., there is no previous number e-1 in the set)
            if (!set.contains(e - 1)) {

                count = 1;

                // Expand the sequence forward (e+1, e+2, ...)
                while (set.contains(e + 1)) {
                    count++;
                    e = e + 1;
                }

                // Update the longest sequence found
                longest = Math.max(longest, count);
            }
        }

        return longest;
    }
}

/*
-----------------------------------
Time Complexity: O(n)
-----------------------------------
- Inserting all elements into the HashSet takes O(n).
- Each element is processed at most once in the while loop.
- Overall complexity is linear.

-----------------------------------
Space Complexity: O(n)
-----------------------------------
- HashSet stores all elements from the input array.
- Requires O(n) additional space.

-----------------------------------
Approach:
-----------------------------------
1. Store all elements in a HashSet for fast lookup.
2. For each number, check if it is the start of a sequence 
   (i.e., no number exists before it).
3. If it is a start, expand forward and count the sequence length.
4. Track the maximum sequence length found.
*/