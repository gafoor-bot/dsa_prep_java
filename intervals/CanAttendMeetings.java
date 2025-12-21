/**
 * Link: https://neetcode.io/problems/meeting-schedule/question?list=neetcode150
 * Merges overlapping intervals in a list.
 *
 * Steps:
 * 1. Sort intervals by start time.
 * 2. Traverse and merge overlapping intervals.
 * 3. Collect merged intervals into the result list.
 */
class Solution {
    public int[][] merge(int[][] intervals) {

        // Step 1: Sort intervals by their start times.
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        // 'prev' holds the interval we are currently merging into.
        int[] prev = intervals[0];
        int n = intervals.length;

        // Step 2: Walk through intervals and merge when overlapping.
        for (int i = 1; i < n; i++) {
            int[] interval = intervals[i];

            // Overlap: current interval starts before or at prev's end.
            if (interval[0] <= prev[1]) {
                // Extend the end of the current merged interval.
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                // No overlap: push 'prev' to result and move to next interval.
                merged.add(prev);
                prev = interval;
            }
        }

        // Step 3: Add the final merged interval.
        merged.add(prev);

        return merged.toArray(new int[merged.size()][]);
    }
}
