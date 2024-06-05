// https://leetcode.com/problems/remove-nth-node-from-end-of-list/

package RemoveNthNodeFromEndOfList;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {

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

    void printList(ListNode head) {
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
        sol.printList(head1);
        var newHead1 = sol.removeNthFromEnd(head1, 2);
        sol.printList(newHead1); // [ 1 2 3 5 ]
        var head2 = new ListNode(1);
        sol.printList(head2);
        var newHead2 = sol.removeNthFromEnd(head2, 1);
        sol.printList(newHead2); // [ ]
    }

}
