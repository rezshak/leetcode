// https://leetcode.com/problems/reverse-linked-list/

import java.util.Stack;

class Solution206 {

    // T: O(n), S: O(1)
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null, curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    // T: O(n), S: O(n)
    public ListNode reverseListStack(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        var st = new Stack<ListNode>();
        var curr = head;
        while (curr != null) {
            st.push(curr);
            curr = curr.next;
        }
        var newHead = st.pop();
        curr = newHead;
        while (!st.isEmpty()) {
            curr.next = st.pop();
            curr = curr.next;
        }
        curr.next = null;
        return newHead;
    }

    // T: O(n), S: O(n)
    public ListNode reverseListRec(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode reversedListHead = reverseListRec(head.next);
        head.next.next = head;
        head.next = null;
        return reversedListHead;
    }

    public static void main(String[] args) {
        var sol = new Solution206();
        var list1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, new ListNode(5, null)))));
        System.out.println(list1); // 1 -> 2 -> 3 -> 4 -> 5
        System.out.println(sol.reverseList(list1)); // 5 -> 4 -> 3 -> 2 -> 1

        var list2 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        System.out.println(list2); // 1 -> 2 -> 3 -> 4
        System.out.println(sol.reverseListStack(list2)); // 4 -> 3 -> 2 -> 1

        var list3 = new ListNode(1, new ListNode(2, new ListNode(3, null)));
        System.out.println(list3); // 1 -> 2 -> 3
        System.out.println(sol.reverseListRec(list3)); // 3 -> 2 -> 1
    }

}
