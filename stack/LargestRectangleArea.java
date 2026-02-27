import java.util.Stack;

class Solution {

    /*Link: https://neetcode.io/problems/largest-rectangle-in-histogram/question
     * Calculates the largest rectangular area in a histogram.
     *
     * @param A array representing heights of histogram bars
     * @return maximum rectangular area
     */
    public int largestRectangleArea(int[] A) {

        int n = A.length;

        // rb[i] = index of the nearest smaller element to the right of i
        int[] rb = new int[n];

        // lb[i] = index of the nearest smaller element to the left of i
        int[] lb = new int[n];

        Stack<Integer> st = new Stack<>();

        /* -------------------------
           Find Right Boundaries (rb)
           ------------------------- */

        // For the last element, no smaller element exists on the right
        rb[n - 1] = n;
        st.push(n - 1);

        // Traverse from right to left
        for (int i = n - 2; i >= 0; i--) {

            // Pop elements until a smaller bar is found
            while (!st.isEmpty() && A[i] <= A[st.peek()]) {
                st.pop();
            }

            // If stack is empty, no smaller element to the right
            rb[i] = st.isEmpty() ? n : st.peek();

            // Push current index
            st.push(i);
        }

        /* ------------------------
           Find Left Boundaries (lb)
           ------------------------ */

        st = new Stack<>();

        // For the first element, no smaller element exists on the left
        lb[0] = -1;
        st.push(0);

        // Traverse from left to right
        for (int i = 1; i < n; i++) {

            // Pop elements until a smaller bar is found
            while (!st.isEmpty() && A[i] <= A[st.peek()]) {
                st.pop();
            }

            // If stack is empty, no smaller element to the left
            lb[i] = st.isEmpty() ? -1 : st.peek();

            // Push current index
            st.push(i);
        }

        /* -----------------------------
           Calculate Maximum Area
           ----------------------------- */

        int max = 0;

        for (int i = 0; i < n; i++) {
            // Width between left and right smaller bars
            int width = rb[i] - lb[i] - 1;

            // Area using A[i] as the smallest bar
            max = Math.max(max, A[i] * width);
        }

        return max;
    }
}

/*
-----------------------------------
Time Complexity:
-----------------------------------
O(n)
- Each element is pushed and popped from the stack at most once.

-----------------------------------
Space Complexity:
-----------------------------------
O(n)
- Arrays lb[], rb[] and the stack each take O(n) space.
*/