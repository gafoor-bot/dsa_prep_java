import java.util.*;

public class Solution {

    /* Link: https://neetcode.io/problems/hand-of-straights/question
     * Checks whether the hand can be rearranged into groups of consecutive numbers
     * of size groupSize.
     *
     * Time Complexity:
     * - Counting frequency: O(n)
     * - Sorting the hand array: O(n log n)
     * - Forming groups: O(n * groupSize) in worst case
     * Overall: O(n log n)
     *
     * Space Complexity:
     * - HashMap to store counts: O(n)
     * - Sorting uses O(1) extra space (in-place for primitives)
     * Overall: O(n)
     */
    public boolean isNStraightHand(int[] hand, int groupSize) {

        // If total cards cannot be evenly divided into groups, return false
        if (hand.length % groupSize != 0) return false;

        // Map to store frequency of each card
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : hand) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Sort the cards to always start forming groups from the smallest number
        Arrays.sort(hand);

        // Try to form consecutive groups starting from each number
        for (int num : hand) {

            // If this number is still available to use
            if (count.get(num) > 0) {

                // Try to form a group of size 'groupSize'
                // Example: if num = 2 and groupSize = 4 → check 2,3,4,5
                for (int i = num; i < num + groupSize; i++) {

                    // If any required number is missing, grouping is impossible
                    if (count.getOrDefault(i, 0) == 0) return false;

                    // Use one occurrence of this number
                    count.put(i, count.get(i) - 1);
                }
            }
        }

        // All cards successfully grouped
        return true;
    }
}
