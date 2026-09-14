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
        ListNode d = new ListNode(0, head);
        ListNode groupP = d;

        while(true) {
            ListNode kth = dfs(groupP, k);
            if(kth == null) {
                break;
            }
            ListNode groupN = kth.next;

            ListNode prev = kth.next;
            ListNode cur = groupP.next;

            while(cur != groupN) {
                ListNode temp = cur.next;
                cur.next = prev;
                prev = cur;
                cur = temp;
            }


            ListNode temp = groupP.next;

            groupP.next = kth;

            groupP = temp;

        }

        return d.next;
    }

    public ListNode dfs(ListNode head, int k) {
        ListNode cur = head;
        while(cur != null && k > 0) {
            cur = cur.next;
            k-=1;
        }
        return cur;
    }

}
