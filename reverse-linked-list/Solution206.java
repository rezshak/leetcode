// https://leetcode.com/problems/reverse-linked-list/

class Solution206 {

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

    public static void main(String[] args) {
        var sol = new Solution206();
        var head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        System.out.println(head1); // 1 -> 2 -> 3 -> 4 -> 5
        head1 = sol.reverseList(head1);
        System.out.println(head1); // 5 -> 4 -> 3 -> 2 -> 1
    }

}
