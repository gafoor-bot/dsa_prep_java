import java.util.Stack;

class Solution {

    /* Link: https://neetcode.io/problems/validate-parentheses/question
     * Function to check whether the given string of brackets is valid.
     * A string is valid if:
     * 1. Every opening bracket has a corresponding closing bracket.
     * 2. Brackets are closed in the correct order.
     */
    public boolean isValid(String s) {

        // Stack to store opening brackets
        Stack<Character> stack = new Stack<>();

        // Traverse each character in the string
        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // If opening bracket, push it onto the stack
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } 
            // If closing bracket
            else {
                // If stack is empty, no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }

                // Pop the top element from the stack
                char top = stack.pop();

                // Check if the popped opening bracket matches the closing bracket
                if ((ch == ')' && top == '(') ||
                    (ch == '}' && top == '{') ||
                    (ch == ']' && top == '[')) {
                    continue;
                } else {
                    return false;
                }
            }
        }

        // If stack is empty, all brackets are matched
        return stack.isEmpty();
    }

    /*
     * Time Complexity: O(n)
     * - We traverse the string once, where n is the length of the string.
     *
     * Space Complexity: O(n)
     * - In the worst case, all opening brackets are stored in the stack.
     */
}