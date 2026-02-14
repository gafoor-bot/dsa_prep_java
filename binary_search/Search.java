class Solution {

    /**
     * Performs Binary Search on a sorted array to find the target element.
     *
     * @param nums   Sorted integer array
     * @param target Element to be searched
     * @return Index of target if found, otherwise -1
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public int search(int[] nums, int target) {

        // Initialize start and end pointers
        int start = 0;
        int end = nums.length - 1;

        // Continue searching while the search space is valid
        while (start <= end) {

            // Calculate mid index to avoid overflow
            int mid = start + (end - start) / 2;

            // If target is found at mid, return its index
            if (nums[mid] == target) {
                return mid;

            // If target is greater, ignore left half
            } else if (nums[mid] < target) {
                start = mid + 1;

            // If target is smaller, ignore right half
            } else {
                end = mid - 1;
            }
        }

        // Target not found
        return -1;
    }
}
