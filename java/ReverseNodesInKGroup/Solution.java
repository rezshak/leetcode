// https://leetcode.com/problems/reverse-nodes-in-k-group/

package ReverseNodesInKGroup;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }
}

public class Solution {

    // T: O(n), S: O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        var fake = new ListNode(-1);
        fake.next = head;
        var groupPrev = fake;
        while (true) {
            var kth = getKth(groupPrev, k);
            if (kth == null) {
                break;
            }
            // reverse group
            var groupNext = kth.next;
            var prev = groupNext;
            var curr = groupPrev.next;
            while (curr != groupNext) {
                var temp = curr.next;
                curr.next = prev;
                prev = curr;
                curr = temp;
            }
            var temp = groupPrev.next;
            groupPrev.next = prev;
            groupPrev = temp;
        }
        return fake.next;
    }

    private ListNode getKth(ListNode node, int k) {
        var curr = node;
        for (int i = 0; i < k; i++) {
            if (curr.next == null) {
                return null;
            }
            curr = curr.next;
        }
        return curr;
    }

    private static void printList(ListNode head) {
        var sb = new StringBuilder();
        var curr = head;
        sb.append("[ ");
        while (curr != null) {
            sb.append(curr.val).append(" ");
            curr = curr.next;
        }
        sb.append("]");
        System.out.println(sb.toString());
    }

    public static void main(String[] args) {
        var sol = new Solution();
        var head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        var newHead1 = sol.reverseKGroup(head1, 2);
        printList(newHead1); // [2 1 4 3 5]
        var head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        var newHead2 = sol.reverseKGroup(head2, 3);
        printList(newHead2); // [3 2 1 4 5]
    }

}
