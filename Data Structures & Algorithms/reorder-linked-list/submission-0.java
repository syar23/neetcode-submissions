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


//(3 steps)
//Find middle with slow/fast pointers.
//Reverse second half of the list.
//Merge alternating: first half + reversed second half.
class Solution {
    public void reorderList(ListNode head) {
    if (head == null || head.next == null) return;

        // 1) Find middle
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Split into two halves: head.. and slow.. (second half starts at slow.next)
        ListNode second = slow.next;
        slow.next = null; // cut

        // 2) Reverse second half
        second = reverse(second);

        // 3) Merge alternating
        ListNode first = head;
        while (second != null) {
            ListNode t1 = first.next;
            ListNode t2 = second.next;

            first.next = second;
            second.next = t1;

            first = t1;
            second = t2;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
