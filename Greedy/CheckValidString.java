import java.util.Stack;

/* Link :https://neetcode.io/problems/valid-parenthesis-string/solution
 * Problem: Valid Parenthesis String
 *
 * Given a string containing '(', ')' and '*',
 * where '*' can represent '(' or ')' or an empty string,
 * determine if the string is valid.
 *
 * Approach:
 * - Use two stacks:
 *   1. left stack to store indices of '('
 *   2. star stack to store indices of '*'
 *
 * - Traverse the string:
 *   - Push index of '(' into left stack
 *   - Push index of '*' into star stack
 *   - For ')', try to match with '(' first, otherwise with '*'
 *
 * - After traversal, try to match remaining '(' with '*' ensuring
 *   '*' appears after '(' (index-based validation)
 *
 * Time Complexity: O(n)
 *   - Single pass through the string
 *   - Stack cleanup also runs in O(n) in worst case
 *
 * Space Complexity: O(n)
 *   - Two stacks storing indices of '(' and '*'
 *
 * Author: Gafoor Shaik
 */
public class Solution {

    public boolean checkValidString(String s) {

        // Stack to store indices of '(' characters
        Stack<Integer> left = new Stack<>();

        // Stack to store indices of '*' characters
        Stack<Integer> star = new Stack<>();

        // Traverse each character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            // If opening parenthesis, store its index
            if (ch == '(') {
                left.push(i);
            }
            // If wildcard '*', store its index
            else if (ch == '*') {
                star.push(i);
            }
            // If closing parenthesis ')'
            else {
                // If no '(' or '*' available to match ')', invalid string
                if (left.isEmpty() && star.isEmpty()) {
                    return false;
                }

                // Prefer matching ')' with '(' if possible
                if (!left.isEmpty()) {
                    left.pop();
                } 
                // Otherwise, use '*' as '('
                else {
                    star.pop();
                }
            }
        }

        // Match remaining '(' with '*' ensuring correct order
        while (!left.isEmpty() && !star.isEmpty()) {
            // If '(' appears after '*', invalid
            if (left.pop() > star.pop()) {
                return false;
            }
        }

        // If no unmatched '(' remain, string is valid
        return left.isEmpty();
    }
}
