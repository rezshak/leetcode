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

class Solution {

    // T: O(n), S: O(1)
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode groupPrev = fake;
        while (true) {
            ListNode kth = getKth(groupPrev, k);
            if (kth == null) {
                break;
            }
            ListNode groupNext = kth.next;
            ListNode newGroupPrev = groupPrev.next; // The head of the current group will be the prev of the next group
            groupPrev.next = reverse(groupPrev.next, groupNext);
            groupPrev = newGroupPrev;
        }
        return fake.next;
    }
    
    private ListNode reverse(ListNode start, ListNode end) {
        ListNode prev = end;
        while (start != end) {
            ListNode temp = start.next;
            start.next = prev;
            prev = start;
            start = temp;
        }
        return prev;
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
