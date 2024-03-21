// https://leetcode.com/problems/palindrome-linked-list/

package PalindromeLinkedList;

import java.util.Stack;

class ListNode {
    final int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        next = null;
    }
}

class Solution {

    public boolean isPalindrome(ListNode head) {
        return true;
    }

    // T: O(n), S: O(n)
    public boolean isPalindromeHalfStack(ListNode head) {
        var st = new Stack<Integer>();
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            st.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        if (fast != null) {
            slow = slow.next;
        }
        while (!st.isEmpty() && slow != null) {
            int val = st.pop();
            if (val != slow.val) {
                return false;
            }
            slow = slow.next;
        }
        return true;
    }

    // T: O(n), S: O(n)
    public boolean isPalindromeFullStack(ListNode head) {
        var st = new Stack<Integer>();
        var curr = head;
        while (curr != null) {
            st.push(curr.val);
            curr = curr.next;
        }
        curr = head;
        while (curr != null) {
            int val = st.pop();
            if (curr.val != val) {
                return false;
            }
            curr = curr.next;
        }
        return true;
    }

    public static void main(String[] args) {
        var sol = new Solution();
        // [1,2,2,1]
        var head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);
        System.out.println(sol.isPalindromeHalfStack(head1)); // true
        // [1,2]
        var head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println(sol.isPalindromeHalfStack(head2)); // false
        // [1,1,2,1]
        var head3 = new ListNode(1);
        head3.next = new ListNode(1);
        head3.next.next = new ListNode(2);
        head3.next.next.next = new ListNode(1);
        System.out.println(sol.isPalindromeHalfStack(head3)); // false
        // [1,0,1]
        var head4 = new ListNode(1);
        head4.next = new ListNode(0);
        head4.next.next = new ListNode(1);
        System.out.println(sol.isPalindromeHalfStack(head4)); // true
    }

}
