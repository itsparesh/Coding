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
    public ListNode swapNodes(ListNode head, int k) {
        if (head == null) return head;
        ListNode first = head;
        ListNode fast = head;
        ListNode second = head;

        for (int i = 1; i < k; i++) {
            first = first.next;
            fast = fast.next;
        }

        while (fast.next != null) {
            fast = fast.next;
            second = second.next;
        }

        if (first != null && second != null) {
            ListNode temp = new ListNode(first.val);
            first.val = second.val;
            second.val = temp.val;   
        }

        return head;
    }
}