/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;        // Value of the node
 *     ListNode next;  // Reference to the next node
 *     
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { 
 *         this.val = val; 
 *         this.next = next; 
 *     }
 * }
 */

class Solution {

    /*Link list:https://neetcode.io/problems/reverse-a-linked-list/question?list=neetcode150
     * Reverses a singly linked list iteratively.
     *
     * Time Complexity: O(n)
     * - Each node is visited exactly once.
     *
     * Space Complexity: O(1)
     * - Reversal is done in-place using constant extra space.
     */
    public ListNode reverseList(ListNode head) {

        // 'curr' points to the current node being processed
        ListNode curr = head;

        // 'prev' will eventually become the new head of the reversed list
        ListNode prev = null;

        // Temporary variable to store the next node
        ListNode next;

        // Traverse the list until the end
        while (curr != null) {

            // Store the next node before breaking the link
            next = curr.next;

            // Reverse the current node's pointer
            curr.next = prev;

            // Move 'prev' one step forward
            prev = curr;

            // Move 'curr' one step forward
            curr = next;
        }

        // 'prev' is the new head of the reversed linked list
        return prev;
    }
}
