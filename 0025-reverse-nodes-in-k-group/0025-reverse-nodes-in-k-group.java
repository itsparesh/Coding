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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode res = new ListNode(0);
        res.next = head;
        ListNode prevGrpEnd = res;
        ListNode prevGrpStart = head;

        while (true) {
            ListNode kthNode = prevGrpEnd;
            for (int i = 0; i < k && kthNode != null; i++) {
                kthNode = kthNode.next;
            }

            if (kthNode == null) break;

            ListNode nextGrpStart = kthNode.next;
            ListNode curr = prevGrpStart;
            ListNode prev = nextGrpStart;

            while (curr != nextGrpStart) {
                ListNode temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }

            prevGrpEnd.next = kthNode;
            prevGrpEnd = prevGrpStart;
            prevGrpStart = nextGrpStart;   
        }
        return res.next;
    }
}