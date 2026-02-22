import java.util.Stack;

class Solution {

    /* Link: https://neetcode.io/problems/daily-temperatures/question
     * Given an array of daily temperatures, returns an array where
     * result[i] is the number of days until a warmer temperature.
     * If no warmer day exists, result[i] = 0.
     */
    public int[] dailyTemperatures(int[] temp) {

        // Stack to store indices of temperatures
        // It maintains a monotonic decreasing stack
        Stack<Integer> st = new Stack<>();

        // Result array to store number of days to wait
        int[] result = new int[temp.length];

        // Traverse through each day's temperature
        for (int i = 0; i < temp.length; i++) {

            // While current temperature is warmer than the temperature
            // at the index stored at the top of the stack
            while (!st.isEmpty() && temp[st.peek()] < temp[i]) {

                int prevIndex = st.pop();

                // Calculate the number of days waited
                result[prevIndex] = i - prevIndex;
            }

            // Push current day's index onto the stack
            st.push(i);
        }

        // Remaining indices in stack do not have a warmer future day
        // Their result values remain 0 by default
        return result;
    }

    /*
     * Time Complexity: O(n)
     * - Each index is pushed and popped from the stack at most once.
     *
     * Space Complexity: O(n)
     * - Stack and result array require linear space in the worst case.
     */
}