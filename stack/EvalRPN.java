import java.util.*;

class Solution {

    /* Link: https://neetcode.io/problems/evaluate-reverse-polish-notation/question
     * Evaluates the value of an arithmetic expression in Reverse Polish Notation (RPN).
     * Valid operators are +, -, *, and /.
     */
    public int evalRPN(String[] tokens) {

        // Set to quickly check if a token is an operator
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

        // Stack to store operands during evaluation
        Stack<Integer> stack = new Stack<>();

        // Traverse each token in the RPN expression
        for (String token : tokens) {

            // If the token is an operator
            if (operators.contains(token)) {

                // Pop the top two operands from the stack
                int secondNum = stack.pop(); // right operand
                int firstNum = stack.pop();  // left operand

                // Perform the operation and push the result back to the stack
                if (token.equals("+")) {
                    stack.push(firstNum + secondNum);
                } else if (token.equals("-")) {
                    stack.push(firstNum - secondNum);
                } else if (token.equals("*")) {
                    stack.push(firstNum * secondNum);
                } else if (token.equals("/")) {
                    // Integer division truncates toward zero
                    stack.push(firstNum / secondNum);
                }

            } else {
                // If the token is a number, push it onto the stack
                stack.push(Integer.valueOf(token));
            }
        }

        // Final result will be the only element left in the stack
        return stack.pop();
    }

    /*
     * Time Complexity: O(n)
     * - Each token is processed exactly once.
     *
     * Space Complexity: O(n)
     * - Stack can store up to n/2 operands in the worst case.
     */
}