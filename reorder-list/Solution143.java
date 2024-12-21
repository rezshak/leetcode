// https://leetcode.com/problems/reorder-list/

class Solution143 {

    // T: O(n), S: O(1)
    public void reorderList(ListNode head) {
        // Find the mid
        var slow = head;
        var fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        var first = head;
        var second = slow.next;
        // Sever the lists
        slow.next = null;
        // Reverse the second list
        ListNode prev = null;
        while (second != null) {
            var secondNext = second.next;
            second.next = prev;
            prev = second;
            second = secondNext;
        }
        second = prev;
        // Rebuild the list
        while (second != null) {
            var firstNext = first.next;
            var secondNext = second.next;
            first.next = second;
            second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }
    }

    public static void main(String[] args) {
        var sol = new Solution143();
        var head1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        System.out.println(head1); // 1 -> 2 -> 3 -> 4
        sol.reorderList(head1);
        System.out.println(head1); // 1 -> 4 -> 2 -> 3
    }

}
