// https://leetcode.com/problems/linked-list-cycle/

class Solution141 {

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

    public static void main(String[] args) {
        var sol = new Solution141();
        // 3,2,0,-4
        var head1 = new ListNode(3);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(0);
        head1.next.next.next = new ListNode(-4);
        System.out.println(head1);
        System.out.println(sol.hasCycle(head1)); // false
        head1.next.next.next.next = head1.next;
        System.out.println(sol.hasCycle(head1)); // true
    }

}
