class Solution {

    /*Link: https://neetcode.io/problems/two-integer-sum-ii/question
     * Finds two numbers in a sorted array that add up to a given target.
     * Uses the two-pointer technique for optimal performance.
     *
     * @param numbers a sorted array of integers (1-indexed result required)
     * @param target the target sum
     * @return an array containing the 1-based indices of the two numbers
     *
     * Time Complexity: O(n)
     *   - Each element is visited at most once by the two pointers.
     *
     * Space Complexity: O(1)
     *   - Uses constant extra space (no additional data structures).
     */
    public int[] twoSum(int[] numbers, int target) {

        // Initialize two pointers:
        // left starts at the beginning, right starts at the end
        int left = 0;
        int right = numbers.length - 1;

        // Continue searching until the two pointers meet
        while (left < right) {

            // Calculate the sum of values at both pointers
            int total = numbers[left] + numbers[right];

            // If the target is found, return 1-based indices
            if (total == target) {
                return new int[]{left + 1, right + 1};
            }
            // If the sum is too large, move the right pointer left
            else if (total > target) {
                right--;
            }
            // If the sum is too small, move the left pointer right
            else {
                left++;
            }
        }

        // If no solution is found (edge case)
        return new int[]{-1, -1};
    }
}
