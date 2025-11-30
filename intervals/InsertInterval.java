/**
 * Inserts a new interval into a list of non-overlapping intervals,
 * merging where necessary. The input intervals are assumed to be
 * sorted by start time.
 */
public class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();

        for (int[] interval : intervals) {

            // Case 1: No overlap, current interval ends before newInterval starts.
            // Add interval as-is.
            if (newInterval == null || interval[1] < newInterval[0]) {
                res.add(interval);

            // Case 2: No overlap, current interval starts after newInterval ends.
            // Add the newInterval first, then the current interval.
            // After adding, set newInterval to null because it's already placed.
            } else if (interval[0] > newInterval[1]) {
                res.add(newInterval);
                res.add(interval);
                newInterval = null;

            // Case 3: Overlap exists → merge the intervals.
            // Expand newInterval's boundaries to encompass the overlapping interval.
            } else {
                newInterval[0] = Math.min(interval[0], newInterval[0]);
                newInterval[1] = Math.max(interval[1], newInterval[1]);
            }
        }

        // If newInterval was never inserted (e.g., it belongs at the end),
        // add it now.
        if (newInterval != null) res.add(newInterval);

        return res.toArray(new int[res.size()][]);
    }
}
