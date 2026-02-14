class Solution {
    /**
     * Returns an array of the maximum values in each sliding window of size k.
     *
     * @param nums input array of integers
     * @param k    size of the sliding window
     * @return     array of maximums for each window
     *
     * Time Complexity: O(n log n)
     *   - Each insertion into the priority queue (heap) takes O(log n)
     *   - Each removal also takes O(log n)
     *   - Total n elements → O(n log n)
     *
     * Space Complexity: O(n)
     *   - Priority queue may contain up to n elements
     *   - Result array of size n-k+1
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        // Max heap storing {value, index}, ordered by value descending
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> b[0] - a[0]);

        int[] result = new int[nums.length - k + 1]; // output array
        int id = 0; // index for result array

        for (int i = 0; i < nums.length; i++) {
            // Add current element along with its index into the heap
            heap.offer(new int[]{nums[i], i});

            // Once we have filled the first window, start recording max
            if (i >= k - 1) {
                // Remove elements from the top of heap if their index is
                // outside the current window [i-k+1, i]
                while (heap.peek()[1] <= i - k) {
                    // Debug: print index being removed
                    System.out.println("Removing stale index: " + heap.peek()[1]);
                    heap.poll();
                }

                // Debug: print index of current maximum in window
                System.out.println("Current max index: " + heap.peek()[1]);

                // The top of the heap is the max for the current window
                result[id++] = heap.peek()[0];
            }
        }

        return result;
    }
}
