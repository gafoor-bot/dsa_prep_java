import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {

        /* Link: https://neetcode.io/problems/merge-triplets-to-form-target/question?list=neetcode150
         * Time Complexity: O(n)
         * - We iterate through each triplet once.
         * - Each triplet has only 3 elements, so all checks are constant time.
         *
         * Space Complexity: O(1)
         * - We use a HashSet that can store at most 3 indices (0, 1, 2).
         * - Extra space does not grow with input size.
         */

        // Set to track which target indices can be matched
        Set<Integer> matchedIndices = new HashSet<>();

        // Loop through all triplets
        for (int[] triplet : triplets) {

            // Skip invalid triplets that exceed the target in any position
            if (triplet[0] > target[0] ||
                triplet[1] > target[1] ||
                triplet[2] > target[2]) {
                continue;
            }

            // Check each index of the triplet
            for (int i = 0; i < 3; i++) {
                // If the value matches the target at this index,
                // mark this index as achievable
                if (triplet[i] == target[i]) {
                    matchedIndices.add(i);
                }
            }
        }

        // If all three indices are matched, we can form the target triplet
        return matchedIndices.size() == 3;
    }
}
