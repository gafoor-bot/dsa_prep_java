class Solution {

    /*
     * Time Complexity: O(n^2)
     * - Sorting the array takes O(n log n)
     * - The outer loop runs O(n)
     * - The two-pointer scan runs O(n) for each element
     *
     * Overall: O(n^2)
     *
     * Space Complexity: O(1) (excluding output list)
     * - No extra space is used apart from the result list
     */
    public List<List<Integer>> threeSum(int[] nums) {

        // Sort the array to use the two-pointer technique
        Arrays.sort(nums);

        // List to store all unique triplets
        List<List<Integer>> list = new LinkedList<>();

        int sum = 0, low = 0, high = 0;

        // Iterate through the array, fixing one number at a time
        for (int i = 0; i < nums.length - 2; i++) {

            /*
             * Skip duplicate elements to avoid duplicate triplets
             */
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {

                // Target sum for the remaining two numbers
                sum = 0 - nums[i];

                // Initialize two pointers
                low = i + 1;
                high = nums.length - 1;

                // Two-pointer approach to find pairs that sum to "sum"
                while (low < high) {

                    if (sum == nums[low] + nums[high]) {

                        // Found a valid triplet
                        list.add(Arrays.asList(nums[i], nums[low], nums[high]));

                        // Skip duplicate values for low pointer
                        while (low < high && nums[low] == nums[low + 1]) low++;

                        // Skip duplicate values for high pointer
                        while (low < high && nums[high] == nums[high - 1]) high--;

                        // Move both pointers inward
                        low++;
                        high--;
                    }
                    // If the sum is too small, move low pointer forward
                    else if (sum > nums[low] + nums[high]) {
                        low++;
                    }
                    // If the sum is too large, move high pointer backward
                    else {
                        high--;
                    }
                }
            }
        }
        return list;
    }
}
