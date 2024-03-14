// https://leetcode.com/problems/middle-of-the-linked-list/

package MiddleOfTheLinkedList;

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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
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
        // 1,2,3,4,5
        var head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        head1.next.next.next.next = new ListNode(5);
        printList(head1);
        System.out.println(sol.middleNode(head1).val); // 3
    }

}
