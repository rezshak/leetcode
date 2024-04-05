// https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/

package DeleteTheMiddleNodeOfALinkedList;

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
    public ListNode deleteMiddle(ListNode head) {
        ListNode fake = new ListNode(-1);
        fake.next = head;
        ListNode prev = fake, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = slow.next;
        return fake.next;
    }

    private void printList(ListNode head) {
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
        var head1 = new ListNode(1); // [1,3,4,7,1,2,6]
        head1.next = new ListNode(3);
        head1.next.next = new ListNode(4);
        head1.next.next.next = new ListNode(7);
        head1.next.next.next.next = new ListNode(1);
        head1.next.next.next.next.next = new ListNode(2);
        head1.next.next.next.next.next.next = new ListNode(6);
        sol.printList(head1);
        head1 = sol.deleteMiddle(head1);
        sol.printList(head1);
    }

}
