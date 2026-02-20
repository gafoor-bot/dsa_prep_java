public class Solution {

    /*Link: https://neetcode.io/problems/find-target-in-rotated-sorted-array/question
     * Searches for a target element in a rotated sorted array.
     *
     * Approach:
     * - Use modified binary search.
     * - At each step, determine which half is sorted.
     * - Check whether the target lies in the sorted half.
     * - Discard the other half accordingly.
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     *
     * @param arr Rotated sorted array with distinct elements
     * @param k   Target element to search
     * @return Index of target if found, otherwise -1
     */
    public int search(int[] arr, int k) {

        int low = 0;
        int high = arr.length - 1;

        // Continue binary search while the search space is valid
        while (low <= high) {

            // Calculate mid to avoid integer overflow
            int mid = low + (high - low) / 2;

            // If target is found at mid, return its index
            if (arr[mid] == k) {
                return mid;
            }

            /*
             * Check if the left half is sorted.
             * If arr[low] <= arr[mid], then left part is sorted.
             */
            if (arr[low] <= arr[mid]) {

                // Check if target lies within the sorted left half
                if (arr[low] <= k && k < arr[mid]) {
                    high = mid - 1; // Search left half
                } else {
                    low = mid + 1;  // Search right half
                }
            }
            /*
             * Otherwise, the right half must be sorted.
             */
            else {

                // Check if target lies within the sorted right half
                if (arr[mid] < k && k <= arr[high]) {
                    low = mid + 1;  // Search right half
                } else {
                    high = mid - 1; // Search left half
                }
            }
        }

        // Target not found
        return -1;
    }
}
