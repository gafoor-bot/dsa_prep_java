class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Edge case: if there are no intervals, no removal is needed
        if (intervals.length == 0) return 0;

        // Sort intervals by start time (ascending)
        // This allows us to compare each interval with its previous one
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int removals = 0; // Counter for the number of intervals to remove

        // Iterate through the intervals starting from the second interval
        for (int i = 1; i < intervals.length; i++) {
            // Check if the current interval overlaps with the previous interval
            if (intervals[i][0] < intervals[i - 1][1]) {
                // Overlap detected → we need to remove one interval
                removals++;

                // Strategy: keep the interval with the smaller end time
                // This helps minimize further overlaps
                intervals[i][1] = Math.min(intervals[i][1], intervals[i - 1][1]);
            }
        }

        // Return total number of removals needed to make intervals non-overlapping
        return removals;
    }
}
