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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        // Step 1: walk to the node just before position `left`
        ListNode beforeLeft = dummy;
        for (int i = 0; i < left - 1; i++) {
            beforeLeft = beforeLeft.next;
        }

        // Step 2: reverse nodes from `left` to `right`
        ListNode prev = null;
        ListNode current = beforeLeft.next;  // this is the node at position `left`
        ListNode leftNode = current;         // remember it — it'll become the tail of the reversed part

        for (int i = 0; i < right - left + 1; i++) {
            ListNode next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        // Step 3: reconnect
        beforeLeft.next = prev;      // connect before-left to new head of reversed part
        leftNode.next = current;     // connect old head (now tail) to what comes after

        return dummy.next;
    }
}
   