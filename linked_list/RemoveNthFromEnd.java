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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Initialize length of list
        int len = 1;

        // Pointers to traverse the list
        ListNode curr = head;     // used to calculate length
        ListNode curr1 = head;    // used to find node to remove
        ListNode top = head;      // keep reference to head for returning

        // Edge case: list is empty or has only one node
        if (head == null || head.next == null)
            return null;

        // Calculate the total length of the linked list
        while (curr.next != null) {
            len++;
            curr = curr.next;
        }

        // Edge case: if the node to remove is the head itself
        if (len == n)
            return head.next;

        // Move curr1 to the (len-n)th node (node just before the one to remove)
        for (int i = 1; i < len - n + 1; i++) {
            head = curr1;
            curr1 = curr1.next;
        }

        // Remove the nth node from end
        head.next = curr1.next;

        // Return the head of the modified list
        return top;
    }
}

/*
Time Complexity: O(L)
- We traverse the list twice:
    1. First traversal to compute length (O(L))
    2. Second traversal to reach node before the one to remove (O(L))
- Total = O(2L) ≈ O(L), where L is the number of nodes in the linked list.

Space Complexity: O(1)
- Only a constant number of pointers are used (curr, curr1, top)
- No extra data structures are allocated
*/
