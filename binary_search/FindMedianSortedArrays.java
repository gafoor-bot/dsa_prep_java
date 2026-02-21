/* Link: https://neetcode.io/problems/median-of-two-sorted-arrays/question
 * Finds the median of two sorted arrays using binary search.
 *
 * Ensures O(log(min(n, m))) time complexity by always
 * performing binary search on the smaller array.
 */
class Solution {

    /**
     * @param nums1 First sorted array
     * @param nums2 Second sorted array
     * @return Median of the two sorted arrays
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Ensure nums1 is the smaller array to minimize binary search space
        if (nums2.length < nums1.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int total = nums1.length + nums2.length;

        // Number of elements in the left partition
        int half = (total + 1) / 2;

        // Binary search range on nums1
        int l = 0;
        int r = nums1.length;

        while (l <= r) {

            // Partition indices
            int i = (l + r) / 2;
            int j = half - i;

            // Boundary values for partitions
            int Aleft  = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
            int Aright = (i < nums1.length) ? nums1[i] : Integer.MAX_VALUE;

            int Bleft  = (j > 0) ? nums2[j - 1] : Integer.MIN_VALUE;
            int Bright = (j < nums2.length) ? nums2[j] : Integer.MAX_VALUE;

            // Correct partition found
            if (Aleft <= Bright && Bleft <= Aright) {

                // Odd total length → median is max of left partition
                if (total % 2 != 0) {
                    return Math.max(Aleft, Bleft);
                }

                // Even total length → average of middle two values
                return (double) (Math.max(Aleft, Bleft) +
                                 Math.min(Aright, Bright)) / 2.0;
            }
            // Move partition left
            else if (Aleft > Bright) {
                r = i - 1;
            }
            // Move partition right
            else {
                l = i + 1;
            }
        }

        // This line should never be reached for valid inputs
        return -1;
    }
}

/*
Time Complexity:
- O(log(min(n, m))), where n and m are the lengths of the input arrays.
  Binary search is performed on the smaller array.

Space Complexity:
- O(1), since only constant extra space is used.
*/