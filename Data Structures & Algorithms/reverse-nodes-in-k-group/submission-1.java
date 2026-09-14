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
        ListNode dummy = new ListNode(0, head);
        ListNode grouPrev = dummy;

        while (true) {
            ListNode kth = dfs(grouPrev, k);
            if (kth == null) {
                break;
            }
            ListNode groupNext = kth.next;
            ListNode prev = kth.next;
            ListNode cur = grouPrev.next;

            while (cur != groupNext) {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }

            ListNode temp = grouPrev.next;
            grouPrev.next = kth;
            grouPrev = temp;
        }

        return dummy.next;
    }

    public ListNode dfs(ListNode node, int k) {
        ListNode cur = node;
        while (cur != null && k > 0) {
            cur = cur.next;
            k -= 1;
        }
        return cur;
    }
}
