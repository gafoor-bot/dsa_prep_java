public class Solution {

    /**
     * Finds the duplicate number in the array.
     *
     * Approach:
     * - Uses the array indices as markers.
     * - For each number, mark the index (num - 1) as visited by negating the value.
     * - If we encounter an already negative value, the number is a duplicate.
     *
     * Constraints Assumed:
     * - Numbers are in the range 1 to n
     * - Exactly one number is duplicated
     */
    public int findDuplicate(int[] nums) {

        // Iterate through each number in the array
        for (int num : nums) {

            // Convert value to index (1-based to 0-based)
            int idx = Math.abs(num) - 1;

            // If the value at this index is already negative,
            // it means this number has been seen before
            if (nums[idx] < 0) {
                return Math.abs(num);
            }

            // Mark this index as visited by negating the value
            nums[idx] *= -1;
        }

        // Fallback (should not be reached based on problem constraints)
        return -1;
    }

    /*
     * Time Complexity:
     * O(n)
     * - We traverse the array once.
     *
     * Space Complexity:
     * O(1)
     * - No extra space is used (modifies the input array in-place).
     */
}
