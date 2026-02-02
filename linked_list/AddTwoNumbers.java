/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    /**
     * Adds two numbers represented as linked lists in reverse order.
     * Each node contains a single digit.
     * Returns the sum as a linked list in the same reverse order.
     * 
     * Example:
     * Input: l1 = [2->4->3], l2 = [5->6->4]
     * Output: [7->0->8]  (because 342 + 465 = 807)
     *
     * Time Complexity: O(max(N, M)) 
     *      - N = length of l1, M = length of l2
     *      - We traverse both lists once.
     * Space Complexity: O(max(N, M))
     *      - Result list has at most max(N, M) + 1 nodes.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        int sum = 0;           // To store sum of current digits + carry
        int carry = 0;         // To store carry over for next digit
        ListNode res = null;   // Pointer to build the result list
        ListNode head = null;  // Head of the result list to return

        // Traverse both lists as long as both have nodes
        while(l1 != null && l2 != null){
            sum = l1.val + l2.val + carry; // sum current digits + carry

            if(res == null){
                // First node in the result list
                res = new ListNode(sum % 10); 
                head = res; // Keep reference to head
            } else {
                // Append new node to result list
                res.next = new ListNode(sum % 10);
                res = res.next; // Move res pointer
            }

            // Move to next nodes
            l1 = l1.next;
            l2 = l2.next;

            // Update carry for next digit
            carry = sum / 10;
        }

        // If l1 is longer, continue adding remaining digits
        while(l1 != null){
            sum = l1.val + carry;
            res.next = new ListNode(sum % 10);
            res = res.next;
            l1 = l1.next;
            carry = sum / 10;
        }

        // If l2 is longer, continue adding remaining digits
        while(l2 != null){
            sum = l2.val + carry;
            res.next = new ListNode(sum % 10);
            res = res.next;
            l2 = l2.next;
            carry = sum / 10;
        }

        // If carry is remaining after last digit, add a new node
        if(carry != 0){
            res.next = new ListNode(carry);
            res = res.next;
        }

        // Return the head of the result list
        return head;
    }
}
