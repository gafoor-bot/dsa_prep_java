public class Solution {

    /**
     * Calculates the least number of time intervals needed to finish all tasks
     * when identical tasks must be separated by at least 'n' cooldown intervals.
     *
     * @param tasks array of task labels ('A' to 'Z')
     * @param n cooldown time between two identical tasks
     * @return minimum total intervals required (including idle time)
     */
    public int leastInterval(char[] tasks, int n) {

        // Frequency array for 26 capital letters
        int[] count = new int[26];
        for (char task : tasks) {
            count[task - 'A']++;
        }

        // Max-heap storing task counts so we always process the most frequent task first
        PriorityQueue<Integer> maxHeap =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int cnt : count) {
            if (cnt > 0) {
                maxHeap.add(cnt);
            }
        }

        int time = 0; // Tracks total intervals elapsed

        // Queue to store tasks currently in cooldown
        // Each element: {remaining_count, available_time}
        Queue<int[]> q = new LinkedList<>();

        // Continue until no tasks exist in heap OR cooldown queue
        while (!maxHeap.isEmpty() || !q.isEmpty()) {
            time++; // each loop = 1 CPU time interval

            if (maxHeap.isEmpty()) {
                // No available tasks → jump time forward to next available cooldown task
                time = q.peek()[1];
            } else {
                // Take the most frequent task
                int cnt = maxHeap.poll() - 1;

                // If still has remaining executions, push it into cooldown queue
                if (cnt > 0) {
                    q.add(new int[]{cnt, time + n});
                }
            }

            // If a task in cooldown becomes available at this exact time,
            // move it back into the heap
            if (!q.isEmpty() && q.peek()[1] == time) {
                maxHeap.add(q.poll()[0]);
            }
        }

        return time;
    }
}
