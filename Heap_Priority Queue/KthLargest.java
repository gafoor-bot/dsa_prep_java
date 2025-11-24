/*
 Problem: Kth Largest Element in a Stream
 Link: https://leetcode.com/problems/kth-largest-element-in-a-stream/
 Category: Heap / Priority Queue
 Difficulty: Easy - Medium
 Approach:
    - Maintain a min-heap that always stores k largest elements.
    - If heap size exceeds k, remove the smallest element.
    - The root of the heap is always the kth largest element.
 Time Complexity:
    - add(): O(log k)
 Space Complexity:
    - O(k) for the heap
*/

import java.util.PriorityQueue;

public class KthLargest {

    private PriorityQueue<Integer> pq = new PriorityQueue<>();
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        for (int num : nums) {
            pq.offer(num);
            if (pq.size() > k) {
                pq.poll(); // remove smallest
            }
        }
    }

    public int add(int val) {
        pq.offer(val);
        if (pq.size() > k) {
            pq.poll();
        }
        return pq.peek(); // kth largest
    }
}
