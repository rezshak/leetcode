// https://leetcode.com/problems/palindrome-linked-list/

import java.util.ArrayList;
import java.util.Stack;

class Solution234 {

    // T: O(n), S: O(n)
    public boolean isPalindrome(ListNode head) {
        var list = new ArrayList<Integer>();
        var curr = head;
        while (curr != null) {
            list.add(curr.val);
            curr = curr.next;
        }
        int left = 0, right = list.size() - 1;
        while (left < right) {
            if (list.get(left) != list.get(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // T: O(n), S: O(1)
    public boolean isPalindromeInPlace(ListNode head) {
        var firstHalfEnd = firstHalfEnd(head);
        var secondHalfStart = reverseList(firstHalfEnd.next);
        var curr1 = head;
        var curr2 = secondHalfStart;
        boolean result = true;
        while (result && curr2 != null) {
            if (curr1.val != curr2.val) {
                result = false;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    private ListNode firstHalfEnd(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private ListNode reverseList(ListNode node) {
        ListNode prev = null, curr = node;
        while (curr != null) {
            var tempNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tempNext;
        }
        return prev;
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
        var sol = new Solution234();
        // [1,2,2,1]
        var head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);
        System.out.println(sol.isPalindrome(head1)); // true
        System.out.println(sol.isPalindromeInPlace(head1)); // true
        System.out.println(sol.isPalindromeHalfStack(head1)); // true
        System.out.println(sol.isPalindromeFullStack(head1)); // true
        // [1,2]
        var head2 = new ListNode(1);
        head2.next = new ListNode(2);
        System.out.println(sol.isPalindrome(head2)); // false
        System.out.println(sol.isPalindromeInPlace(head2)); // false
        System.out.println(sol.isPalindromeHalfStack(head2)); // false
        System.out.println(sol.isPalindromeFullStack(head2)); // false
        // [1,1,2,1]
        var head3 = new ListNode(1);
        head3.next = new ListNode(1);
        head3.next.next = new ListNode(2);
        head3.next.next.next = new ListNode(1);
        System.out.println(sol.isPalindrome(head3)); // false
        System.out.println(sol.isPalindromeInPlace(head3)); // false
        System.out.println(sol.isPalindromeHalfStack(head3)); // false
        System.out.println(sol.isPalindromeFullStack(head3)); // false
        // [1,0,1]
        var head4 = new ListNode(1);
        head4.next = new ListNode(0);
        head4.next.next = new ListNode(1);
        System.out.println(sol.isPalindrome(head4)); // true
        System.out.println(sol.isPalindromeInPlace(head4)); // true
        System.out.println(sol.isPalindromeHalfStack(head4)); // true
        System.out.println(sol.isPalindromeFullStack(head4)); // true
    }

}
