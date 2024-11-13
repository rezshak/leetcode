// https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/

class Solution2130 {

    // T: O(n), S: O(1)
    public int pairSum(ListNode head) {
        var firstHalfEnd = firstHalfEnd(head);
        var secondHalfStart = reverseList(firstHalfEnd.next);
        int maxTwinSum = 0;
        var curr1 = head;
        var curr2 = secondHalfStart;
        while (curr2 != null) {
            int currSum = curr1.val + curr2.val;
            maxTwinSum = Math.max(maxTwinSum, currSum);
            curr1 = curr1.next;
            curr2 = curr2.next;
        }
        firstHalfEnd.next = reverseList(secondHalfStart);
        return maxTwinSum;
    }

    // T: O(n), S: O(1)
    private ListNode firstHalfEnd(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // T: O(n), S: O(1)
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

    public static void main(String[] args) {
        var sol = new Solution2130();
        var head1 = new ListNode(5, new ListNode(4, new ListNode(2, new ListNode(1))));
        var head2 = new ListNode(4, new ListNode(2, new ListNode(2, new ListNode(3))));
        var head3 = new ListNode(1, new ListNode(100000));
        System.out.println(sol.pairSum(head1)); // 6
        System.out.println(sol.pairSum(head2)); // 7
        System.out.println(sol.pairSum(head3)); // 100001
    }

}
