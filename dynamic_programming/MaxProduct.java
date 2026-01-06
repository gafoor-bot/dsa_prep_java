class Solution {

    /* Link: https://neetcode.io/problems/maximum-product-subarray/question?list=neetcode150
     * Finds the maximum product of a contiguous subarray.
     *
     * Approach:
     * - Traverse the array from both left-to-right (prefix product)
     *   and right-to-left (suffix product).
     * - Reset prefix or suffix to 1 when product becomes 0,
     *   since any subarray after 0 can start fresh.
     * - Keep track of the maximum product encountered.
     *
     * @param arr input array of integers
     * @return maximum product of a subarray
     *
     * Time Complexity: O(n)
     * - Single pass through the array.
     *
     * Space Complexity: O(1)
     * - Uses only constant extra space.
     */
    public int maxProduct(int[] arr) {

        int n = arr.length; // Size of the array

        int pre = 1;   // Prefix product
        int suff = 1;  // Suffix product
        int ans = Integer.MIN_VALUE; // Stores maximum product found

        for (int i = 0; i < n; i++) {

            // Reset prefix product if it becomes zero
            if (pre == 0) pre = 1;

            // Reset suffix product if it becomes zero
            if (suff == 0) suff = 1;

            // Calculate prefix product from left
            pre *= arr[i];

            // Calculate suffix product from right
            suff *= arr[n - i - 1];

            // Update maximum product
            ans = Math.max(ans, Math.max(pre, suff));
        }

        return ans;
    }
}
