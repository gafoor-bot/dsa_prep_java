import java.util.Arrays;

/*Link: https://neetcode.io/problems/eating-bananas/question
 * Finds the minimum eating speed (bananas per hour) such that
 * all banana piles can be eaten within h hours.
 *
 * Uses binary search on the possible eating speeds.
 */
public class Solution {

    /**
     * @param piles Array where piles[i] is the number of bananas in the ith pile
     * @param h     Total number of hours available
     * @return Minimum integer eating speed
     */
    public int minEatingSpeed(int[] piles, int h) {

        // Minimum possible eating speed
        int l = 1;

        // Maximum possible eating speed (largest pile)
        int r = Arrays.stream(piles).max().getAsInt();

        // Store the best (minimum valid) speed found
        int res = r;

        // Binary search over possible eating speeds
        while (l <= r) {

            // Midpoint represents current eating speed
            int k = (l + r) / 2;

            long totalTime = 0;

            // Calculate total hours needed at speed k
            for (int p : piles) {
                // Ceiling division to account for partial hours
                totalTime += Math.ceil((double) p / k);
            }

            // If we can eat all bananas within h hours
            if (totalTime <= h) {
                // k is a valid speed, try to find a smaller one
                res = k;
                r = k - 1;
            } else {
                // k is too slow, need to increase speed
                l = k + 1;
            }
        }

        return res;
    }
}

/*
Time Complexity:
- O(n log m), where:
  n = number of piles
  m = maximum number of bananas in a pile
  Binary search runs in log m iterations, and each iteration scans all piles.

Space Complexity:
- O(1), using only constant extra space (excluding input array).
*/