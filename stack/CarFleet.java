import java.util.*;

public class Solution {

    /**
     * Link: https://neetcode.io/problems/car-fleet/question
     *
     * Approach:
     * 1. Pair each car's position with its speed.
     * 2. Sort cars by position in descending order (closest to target first).
     * 3. Traverse cars and compute time to reach the target.
     * 4. Use a stack to track fleet times:
     *    - If current car takes longer than the fleet ahead, it forms a new fleet.
     *    - Otherwise, it joins the existing fleet.
     *
     * @param target   Destination point
     * @param position Starting positions of cars
     * @param speed    Speed of each car
     * @return Number of car fleets reaching the target
     *
     * Time Complexity:
     *   O(n log n) → Sorting the cars by position
     *
     * Space Complexity:
     *   O(n) → Stack used to store fleet times
     */
    public int carFleet(int target, int[] position, int[] speed) {

        int n = position.length;

        // Edge case: no cars
        if (n == 0) return 0;

        // cars[i][0] = position, cars[i][1] = speed
        int[][] cars = new int[n][2];

        // Build position-speed pairs
        for (int i = 0; i < n; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        // Sort cars by position descending (closest to target first)
        Arrays.sort(cars, (a, b) -> Integer.compare(b[0], a[0]));

        // Stack to store time taken by each fleet to reach target
        Stack<Double> stack = new Stack<>();

        // Traverse cars from closest to farthest
        for (int[] car : cars) {

            // Time = distance / speed
            double time = (double) (target - car[0]) / car[1];

            /*
             * If stack is empty → first fleet
             * If current car takes longer than the fleet ahead → new fleet
             * Else → joins existing fleet (do nothing)
             */
            if (stack.isEmpty() || time > stack.peek()) {
                stack.push(time);
            }
        }

        // Number of fleets equals number of unique times in stack
        return stack.size();
    }
}