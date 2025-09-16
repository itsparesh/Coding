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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        
        // Count nodes and find tail
        int count = 1;
        ListNode tail = head;
        while (tail.next != null) {
            count++;
            tail = tail.next;
        }
        
        // Reduce k to effective rotation
        k = k % count;
        if (k == 0) return head;
        
        // Find the new tail (count - k - 1)th node
        ListNode newTail = head;
        for (int i = 0; i < count - k - 1; i++) {
            newTail = newTail.next;
        }
        
        // New head is next node after new tail
        ListNode newHead = newTail.next;
        
        // Break the connection and reconnect
        newTail.next = null;
        tail.next = head;
        
        return newHead;
    }
}
