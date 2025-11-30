/**
 * MedianFinder maintains a running list of numbers and allows
 * efficient retrieval of the median at any time.
 *
 * It uses two heaps:
 * - maxHeap: stores the smaller half of the numbers (max at top)
 * - minHeap: stores the larger half of the numbers (min at top)
 *
 * This ensures:
 * - All elements in maxHeap <= all elements in minHeap
 * - Sizes differ by at most 1
 *
 * Median is:
 * - Top of maxHeap when total count is odd
 * - Average of both tops when even
 */
class MedianFinder {

    // Min-heap for the larger half of the numbers
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // Max-heap for the smaller half of the numbers
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    public MedianFinder() {}

    /**
     * Adds a number to the data structure.
     * Steps:
     * 1. Always push into maxHeap first.
     * 2. Move the largest element from maxHeap to minHeap.
     * 3. Balance the heaps so maxHeap never has fewer elements than minHeap.
     */
    public void addNum(int num) {
        // Step 1: push into maxHeap
        maxHeap.offer(num);

        // Step 2: ensure ordering property (maxHeap <= minHeap)
        minHeap.offer(maxHeap.poll());

        // Step 3: balance sizes (maxHeap should hold the extra element if odd count)
        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }

    /**
     * Returns the median of all inserted numbers.
     * If odd count, return top of maxHeap.
     * If even, return average of tops of both heaps.
     */
    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (minHeap.peek() + maxHeap.peek()) / 2.0;
    }
}
