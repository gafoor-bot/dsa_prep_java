import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    /**
    *link: https://neetcode.io/problems/last-stone-weight/question?list=neetcode150
     * Problem: Last Stone Weight
     * Given an array of stones with positive integer weights, repeatedly smash the two heaviest stones together.
     * - If they are equal, both stones are destroyed.
     * - If they are unequal, the smaller stone is destroyed, and the larger stone's weight is reduced by the smaller stone's weight.
     * Return the weight of the last remaining stone, or 0 if none remain.
     */
    public int lastStoneWeight(int[] stones) {
        // Create a max-heap (priority queue in descending order)
        PriorityQueue<Integer> priorityQ = new PriorityQueue<>(Collections.reverseOrder());

        // Add all stones to the max-heap
        for (int ele : stones) {
            priorityQ.add(ele);
        }

        // Continue smashing stones until at most one stone is left
        while (priorityQ.size() > 1) {
            int firstMax = priorityQ.remove();   // heaviest stone
            int secondMax = priorityQ.remove();  // second heaviest stone

            // Print the difference for debugging (optional)
            System.out.println(firstMax - secondMax);

            // If stones are not equal, push the remaining weight back into the heap
            if (firstMax != secondMax) {
                priorityQ.add(firstMax - secondMax);
            }
        }

        // Return the last stone's weight, or 0 if none remain
        return priorityQ.size() > 0 ? priorityQ.peek() : 0;
    }
}
