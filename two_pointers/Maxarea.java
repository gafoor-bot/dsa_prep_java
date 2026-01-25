class Solution {

    /*
     * Time Complexity: O(n)
     * - Each pointer (start and end) moves at most n times.
     * - The array is traversed only once.
     *
     * Space Complexity: O(1)
     * - Uses constant extra space.
     */
    public int maxArea(int[] heights) {

        // Initialize two pointers at both ends of the array
        int start = 0;
        int end = heights.length - 1;

        // Variable to store the maximum area
        int max = -1;

        // Continue until the two pointers meet
        while (start < end) {

            // Calculate the area using the current pointers
            int area = (end - start) * Math.min(heights[start], heights[end]);

            // Update maximum area if current area is larger
            max = Math.max(max, area);

            /*
             * Move the pointer with the smaller height inward.
             * This is a greedy choice because the shorter height
             * limits the area.
             */
            if (heights[start] < heights[end]) {
                start++;
            } else {
                end--;
            }
        }

        // Return the maximum water container area
        return max;
    }
}
