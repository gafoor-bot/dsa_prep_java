// Link: https://neetcode.io/problems/top-k-elements-in-list/question
public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // Step 1: Count frequency of each element using a HashMap
        // Key = number, Value = frequency
        Map<Integer, Integer> count = new HashMap<>();
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }

        // Step 2: Use a Min-Heap (PriorityQueue)
        // Each element in heap = {frequency, number}
        // Heap is ordered by frequency (smallest at the top)
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        // Step 3: Iterate through the frequency map
        for (Map.Entry<Integer, Integer> entry : count.entrySet()) {
            // Add current element to heap
            heap.offer(new int[]{entry.getValue(), entry.getKey()});

            // If heap size exceeds k, remove the smallest frequency element
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Step 4: Extract elements from heap into result array
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            // heap.poll() returns {frequency, number}
            res[i] = heap.poll()[1];
        }

        return res;
    }
}

/*
Time Complexity:
- O(n) to build the frequency map
- O(n log k) to maintain the heap (each insert/remove takes log k)
Overall: O(n log k)

Space Complexity:
- O(n) for the HashMap storing frequencies
- O(k) for the heap
Overall: O(n)
*/