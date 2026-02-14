public class Solution {

    /* Link: https://neetcode.io/problems/search-2d-matrix/question?list=neetcode150
     * Searches for a target value in a 2D matrix using Binary Search.
     * The matrix is treated as a flattened sorted array.
     *
     * @param matrix 2D integer matrix where:
     *               - Integers in each row are sorted in ascending order
     *               - First integer of each row is greater than the last integer of the previous row
     * @param target Value to search for
     * @return true if target exists in matrix, otherwise false
     *
     * Time Complexity: O(log(m * n))
     * Space Complexity: O(1)
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        // Total number of rows and columns
        int ROWS = matrix.length;
        int COLS = matrix[0].length;

        // Binary search boundaries over the virtual 1D array
        int left = 0;
        int right = ROWS * COLS - 1;

        // Perform binary search
        while (left <= right) {

            // Calculate mid index safely to avoid overflow
            int mid = left + (right - left) / 2;

            // Convert 1D index into 2D matrix coordinates
            int row = mid / COLS;
            int col = mid % COLS;

            // If target is greater, search the right half
            if (target > matrix[row][col]) {
                left = mid + 1;

            // If target is smaller, search the left half
            } else if (target < matrix[row][col]) {
                right = mid - 1;

            // Target found
            } else {
                return true;
            }
        }

        // Target not found in matrix
        return false;
    }
}
