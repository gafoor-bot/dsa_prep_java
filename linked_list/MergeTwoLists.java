/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;        // Value stored in the node
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

    /* Link: https://neetcode.io/problems/merge-two-sorted-linked-lists/history
     * Merges two sorted singly linked lists into one sorted list.
     *
     * Time Complexity: O(n + m)
     * - Where n is the number of nodes in list1 and
     *   m is the number of nodes in list2.
     *
     * Space Complexity: O(n + m)
     * - New nodes are created for the merged list.
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Dummy node to simplify edge cases (e.g., empty result list)
        ListNode result = new ListNode(0);

        // Pointer to build and traverse the merged list
        ListNode support = result;

        // Traverse both lists while neither is exhausted
        while (list1 != null && list2 != null) {

            // Compare values and attach the smaller one
            if (list1.val <= list2.val) {
                result.next = new ListNode(list1.val);
                list1 = list1.next;
            } else {
                result.next = new ListNode(list2.val);
                list2 = list2.next;
            }

            // Move the result pointer forward
            result = result.next;
        }

        // Append remaining nodes from list1, if any
        while (list1 != null) {
            result.next = new ListNode(list1.val);
            list1 = list1.next;
            result = result.next;
        }

        // Append remaining nodes from list2, if any
        while (list2 != null) {
            result.next = new ListNode(list2.val);
            list2 = list2.next;
            result = result.next;
        }

        // Return the merged list, skipping the dummy node
        return support.next;
    }
}
