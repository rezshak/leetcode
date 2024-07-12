// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

class Solution19 {

    // T: O(n), S: O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var fake = new ListNode(-1, head);
        var left = fake;
        var right = head;
        for (int i = 0; i < n && right != null; i++) {
            right = right.next;
        }
        while (right != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return fake.next;
    }

    public static void main(String[] args) {
        var sol = new Solution19();
        var head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        ListNode.printList(head1);
        var newHead1 = sol.removeNthFromEnd(head1, 2);
        ListNode.printList(newHead1); // [ 1 2 3 5 ]
        var head2 = new ListNode(1);
        ListNode.printList(head2);
        var newHead2 = sol.removeNthFromEnd(head2, 1);
        ListNode.printList(newHead2); // [ ]
    }

}
