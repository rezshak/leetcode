// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

class Solution19 {

    // T: O(n), S: O(1)
    public ListNode removeNthFromEnd(ListNode head, int n) {
        var right = head;
        for (int i = 0; i < n && right != null; i++) {
            right = right.next;
        }
        if (right == null) {
            return head.next;
        }
        var left = head;
        while (right.next != null) {
            right = right.next;
            left = left.next;
        }
        left.next = left.next.next;
        return head;
    }

    // T: O(n), S: O(1)
    public ListNode removeNthFromEndTwoPass(ListNode head, int n) {
        if (head == null) {
            return head;
        }
        int size = 0;
        var curr = head;
        while (curr != null) {
            curr = curr.next;
            size++;
        }
        if (size == n) {
            return head.next;
        }
        var prev = head;
        for (int i = 0; i < size - n - 1; i++) {
            prev = prev.next;
        }
        prev.next = prev.next.next;
        return head;
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
        var head3 = new ListNode(3, new ListNode(4));
        var newHead3 = sol.removeNthFromEndTwoPass(head3, 1);
        ListNode.printList(newHead3); // [ 3 ]
    }

}
