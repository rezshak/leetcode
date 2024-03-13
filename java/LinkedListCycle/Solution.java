// https://leetcode.com/problems/linked-list-cycle/

package LinkedListCycle;

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
    public boolean hasCycle(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }

    private static void printList(ListNode head) {
        System.out.print("[ ");
        var curr = head;
        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.println("]");
    }

    public static void main(String[] args) {
        var sol = new Solution();
        // 3,2,0,-4
        var head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(4);
        printList(head1);
        System.out.println(sol.hasCycle(head1)); // false
        head1.next.next.next.next = head1.next;
        System.out.println(sol.hasCycle(head1)); // true
    }

}
