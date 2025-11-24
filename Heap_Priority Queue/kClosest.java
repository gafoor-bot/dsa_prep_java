import java.util.PriorityQueue;

class Solution {
    /**
     * Link: https://neetcode.io/problems/k-closest-points-to-origin/question?list=neetcode150
     * Problem: K Closest Points to Origin
     * Given an array of points in 2D space, return the k points closest to the origin (0, 0).
     * Distance is defined using the Euclidean distance formula:
     *      distance = sqrt(x^2 + y^2)
     * 
     * Approach:
     * 1. Use a min-heap (PriorityQueue) to sort points by their distance from the origin.
     * 2. Compute squared distance (x^2 + y^2) to avoid unnecessary square roots.
     * 3. Add all points to the heap along with their distance.
     * 4. Poll the heap k times to get the k closest points.
     */
    public int[][] kClosest(int[][] points, int k) {
        // Min-heap based on squared distance: smallest distance at the top
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // Compute squared distance for each point and add to the heap
        for (int i = 0; i < points.length; i++) {
            int sum = points[i][0] * points[i][0] + points[i][1] * points[i][1]; // x^2 + y^2
            pq.add(new int[]{points[i][0], points[i][1], sum}); // store x, y, distance squared
        }

        // Prepare the result array to store the k closest points
        int[][] results = new int[k][2];

        // Extract the k points with smallest distance from the heap
        for (int i = 0; i < k; i++) {
            int[] point = pq.poll();        // get point with smallest distance
            results[i][0] = point[0];       // x-coordinate
            results[i][1] = point[1];       // y-coordinate
        }

        return results;
    }
}
