import java.util.*;

public class Solution {
    /*https://neetcode.io/problems/minimum-interval-including-query/question
     * Find the length of the shortest interval that includes each query.
     * 
     * @param intervals 2D array of intervals [left, right]
     * @param queries Array of queries
     * @return int[] array of shortest interval lengths for each query (or -1 if none)
     * 
     * Time Complexity: O(n log n + q log q) 
     *   - Sorting intervals: O(n log n)
     *   - Sorting queries: O(q log q)
     *   - Each interval pushed/popped from heap at most once: O(n log n)
     *   - Each query heap peek is O(1)
     *   => Total: O((n + q) log n)
     * 
     * Space Complexity: O(n + q)
     *   - Heap can contain up to n intervals
     *   - Map stores q entries
     */
    public int[] minInterval(int[][] intervals, int[] queries) {
        // Step 1: Sort intervals by start (left value)
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        
        // Step 2: Min-heap stores intervals as [length, right]
        // Top of heap always gives the smallest interval length
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        
        // Step 3: Map to store answer for each query
        Map<Integer, Integer> res = new HashMap<>();
        
        int i = 0; // pointer for intervals array
        
        // Step 4: Process queries in sorted order for efficiency
        for (int q : Arrays.stream(queries).sorted().toArray()) {
            // Add all intervals that start before or at the current query
            while (i < intervals.length && intervals[i][0] <= q) {
                int l = intervals[i][0];
                int r = intervals[i][1];
                int length = r - l + 1;
                
                // Push [length, right] into heap
                minHeap.offer(new int[]{length, r});
                i++;
            }

            // Remove intervals from heap that end before the current query
            while (!minHeap.isEmpty() && minHeap.peek()[1] < q) {
                minHeap.poll();
            }

            // If heap is empty → no interval covers this query → store -1
            // Else → top of heap is the smallest interval length
            res.put(q, minHeap.isEmpty() ? -1 : minHeap.peek()[0]);
        }

        // Step 5: Build result array in original query order
        int[] result = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            result[j] = res.get(queries[j]);
        }
        
        return result;
    }
}