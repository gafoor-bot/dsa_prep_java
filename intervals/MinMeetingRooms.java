/**
 Link: https://neetcode.io/problems/meeting-schedule-ii/question?list=neetcode150
 * Definition of Interval:
 * Represents a meeting time with a start and end.
 */
public class Interval {
    public int start;
    public int end;

    public Interval(int start, int end) {
        this.start = start;
        this.end = end;
    }
}

public class Solution {

    /**
     * Returns the minimum number of meeting rooms required
     * so that no meetings overlap.
     *
     * Approach:
     * 1. Sort meetings by their start time.
     * 2. Use a min-heap (PriorityQueue) to track the earliest
     *    ending meeting room.
     * 3. If the current meeting starts after or exactly when
     *    the earliest meeting ends, reuse that room.
     * 4. Otherwise, allocate a new room.
     *
     * Time Complexity: O(n log n)
     *   - Sorting intervals: O(n log n)
     *   - Heap operations for each interval: O(log n)
     *
     * Space Complexity: O(n)
     *   - In the worst case, all meetings overlap and occupy the heap
     */
    public int minMeetingRooms(List<Interval> intervals) {

        // Edge case: no meetings
        if (intervals == null || intervals.isEmpty()) {
            return 0;
        }

        // Sort intervals based on start time
        intervals.sort((a, b) -> a.start - b.start);

        // Min-heap to store end times of meetings
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Iterate through each meeting interval
        for (Interval interval : intervals) {

            // If the earliest ending meeting ends before
            // or exactly when the current meeting starts,
            // reuse that meeting room
            if (!minHeap.isEmpty() && minHeap.peek() <= interval.start) {
                minHeap.poll();
            }

            // Allocate a room for the current meeting
            // (either reused or new)
            minHeap.offer(interval.end);
        }

        // The size of the heap represents the minimum
        // number of meeting rooms required
        return minHeap.size();
    }
}
