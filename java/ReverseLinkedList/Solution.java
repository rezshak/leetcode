// https://leetcode.com/problems/reverse-linked-list/

package ReverseLinkedList;

class ListNode {
    final int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }
}

class Solution {

    // T: O(n), S: O(1)
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode reversedListHead = reverseListRec(head.next);
        head.next.next = head;
        head.next = null;
        return reversedListHead;
    }

    private static void printList(ListNode head) {
        var sb = new StringBuilder();
        sb.append("[ ");
        var curr = head;
        while (curr != null) {
            sb.append(curr.val).append(" ");
            curr = curr.next;
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        printList(head1);
        head1 = sol.reverseList(head1);
        printList(head1);
    }

}
