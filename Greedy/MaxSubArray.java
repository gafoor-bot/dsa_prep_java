class Solution {
    /*link: https://neetcode.io/problems/maximum-subarray/question
    public int maxSubArray(int[] nums) {
        // curr_sum will track the sum of the current subarray
        int curr_sum = 0;
        // max_sum will track the maximum subarray sum found so far
        // initialize with first element to handle all-negative array case
        int max_sum = nums[0];

        // If array has only one element, return it
        if (nums.length == 1) return nums[0];

        // Iterate through each element in the array
        for (int i = 0; i < nums.length; i++) {
            // If current sum becomes negative, reset it to 0
            // because a negative sum would decrease any future subarray sum
            if (curr_sum < 0) {
                curr_sum = 0;
            }

            // Add current element to current sum
            curr_sum += nums[i];

            // Update max_sum if the current sum is greater than max_sum
            max_sum = Math.max(curr_sum, max_sum);
        }

        // Return the largest subarray sum found
        return max_sum;
    }
}
