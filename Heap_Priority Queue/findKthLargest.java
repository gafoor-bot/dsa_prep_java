import java.util.PriorityQueue;

class Solution {

    /**
     * Link: https://neetcode.io/problems/kth-largest-element-in-an-array/question?list=neetcode150
     * Finds the K-th largest element in an unsorted array.
     *
     * Explanation:
     * We use a min-heap (PriorityQueue in Java). The idea:
     * 1. Insert all numbers into the min-heap.
     * 2. If the heap size becomes greater than (n - k + 1),
     *    remove the smallest elements until only the largest K elements remain.
     * 3. The top of the heap will then contain the K-th largest number.
     *
     * This approach is easy to write but not optimal (O(n log n)).
     *
     * @param nums The input array of integers.
     * @param k The order of the largest number to find.
     * @return The K-th largest element in nums.
     */
    public int findKthLargest(int[] nums, int k) {

        // Min-heap to store all elements
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Add all numbers to the heap
        for (int num : nums) {
            pq.add(num);
        }

        // Remove elements until the heap size is exactly k
        // pq.size() - k gives how many smallest numbers we need to discard
        while (pq.size() > k) {
            pq.poll(); // removes smallest element
        }

        // The top element is now the K-th largest
        return pq.peek();
    }
}
