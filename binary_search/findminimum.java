/*Link: https://neetcode.io/problems/find-minimum-in-rotated-sorted-array/question
 * Finds the minimum element in a rotated sorted array with no duplicates.
 *
 * The array is assumed to be originally sorted in ascending order
 * and then rotated at an unknown pivot.
 */
public class Solution {

    /**
     * Uses binary search to find the minimum element.
     *
     * @param nums Rotated sorted array
     * @return Minimum element in the array
     */
    public int findMin(int[] nums) {
        // Left and right pointers
        int l = 0;
        int r = nums.length - 1;

        // Initialize result with the first element
        int res = nums[0];

        // Binary search loop
        while (l <= r) {

            // If the current subarray is already sorted,
            // the leftmost element is the minimum
            if (nums[l] < nums[r]) {
                res = Math.min(res, nums[l]);
                break;
            }

            // Calculate middle index
            int m = (l + r) / 2;

            // Update result with the middle element
            res = Math.min(res, nums[m]);

            // Decide which half to search next
            if (nums[m] >= nums[l]) {
                // Left half is sorted, so minimum must be in right half
                l = m + 1;
            } else {
                // Right half is sorted, so minimum must be in left half
                r = m - 1;
            }
        }

        return res;
    }
}

/*
Time Complexity:
- O(log n), because binary search reduces the search space by half each iteration.

Space Complexity:
- O(1), since only constant extra space is used.
*/
